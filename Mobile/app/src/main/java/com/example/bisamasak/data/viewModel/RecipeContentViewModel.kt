package com.example.bisamasak.data.viewModel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.BahanResep
import com.example.bisamasak.data.dataContainer.IngredientResponse
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.instance.BisaMasakInstance
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.utils.VideoUtils
import com.example.bisamasak.data.utils.compressImage
import com.example.bisamasak.data.utils.prepareFilePart
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class RecipeContentViewModel : ViewModel() {
    private val _recipeList = MutableStateFlow<List<RecipeContentResponse>>(emptyList())
    private val _searchResult = MutableStateFlow<List<RecipeContentResponse>>(emptyList())
    private val _langkahInputs = mutableStateListOf<LangkahInput>()

    val allRecipeList: StateFlow<List<RecipeContentResponse>> = _recipeList.asStateFlow()
    var recipeList = _recipeList
        .map { list -> list.filter { it.status_konten == "Terunggah" } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    var selectedRecipe by mutableStateOf<RecipeContentResponse?>(null)
    var searchResult = _searchResult.asStateFlow()
    var uploadingRecipe by mutableStateOf<RecipeContentResponse?>(null)
    var uploadProgress by mutableFloatStateOf(0f)

    var isLoading by mutableStateOf(false)
    var loadingState by mutableStateOf(LoadingState.Idle)
    var navigateAfterUpload by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
    var uploadSuccessMessage by mutableStateOf<String?>(null)
    var uploadErrorMessage by mutableStateOf<String?>(null)

//    Add Content
    var ingredientInputs = mutableStateListOf<IngredientInput>()
    var ingredientList by  mutableStateOf<List<IngredientResponse>>(emptyList())
    val langkahInputs: List<LangkahInput> = _langkahInputs
    var addRecipeState by mutableStateOf(AddRecipeState())

//    Edit Content
    var isEditMode by mutableStateOf(false)
    var editingRecipeId: Int? = null

    fun recipe() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = BisaMasakInstance.bisaMasakService.recipeContent()
                _recipeList.value = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }

    fun recipeDetails(recipeId: Int, forEdit: Boolean = false) {
        viewModelScope.launch {
            if (forEdit) {
                loadingState = LoadingState.Editing
            } else {
                loadingState = LoadingState.Loading
            }

            try {
                val response = BisaMasakInstance.bisaMasakService.getRecipeById(recipeId)
                selectedRecipe = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                loadingState = LoadingState.Idle
            }
        }
    }

    fun similarRecipe(recipeId: Int, ingredient: List<BahanResep>): List<RecipeContentResponse> {
        val allRecipes = _recipeList.value.filter { it.id_resep != recipeId }
        val currentIngredient = ingredient.map {
            it.bahan_masak_table?.nama_bahan?.lowercase() ?: ""
        }.filter { it.isNotBlank() }.toSet()

        return allRecipes.map { recipe ->
            val ingredientName = recipe.bahan_resep_table.map {
                it.bahan_masak_table?.nama_bahan?.lowercase() ?: ""
            }.filter { it.isNotBlank() }.toSet()

            val commonIngredient = currentIngredient.intersect(ingredientName)
            recipe to commonIngredient.size
        }
            .filter { (_, count) -> count > 0 }
            .sortedByDescending { (_, count) -> count }
            .take(5)
            .map { (recipe, _) -> recipe }
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                val keywords = query.lowercase()
                    .split(",", " ", ";")
                    .map { it.trim() }
                    .filter { it.isNotBlank() }

                val response = BisaMasakInstance.bisaMasakService.searchRecipes(keywords)
                _searchResult.value = response
            } catch (e: Exception) {
                _searchResult.value = emptyList()
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    //    Store Recipe
    fun loadIngredient() {
        viewModelScope.launch {
            try {
                ingredientList = BisaMasakInstance.bisaMasakService.ingredient()
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            }
        }
    }

    fun addLangkah() {
        _langkahInputs.add(LangkahInput(nomor = _langkahInputs.size + 1))
        addRecipeState = addRecipeState.copy(langkah = _langkahInputs.toList())
    }

    fun updateLangkah(index: Int, newValue: LangkahInput) {
        if (index in _langkahInputs.indices) {
            _langkahInputs[index] = newValue
            addRecipeState = addRecipeState.copy(langkah = _langkahInputs.toList())
        }
    }

    fun removeLangkah(index: Int) {
        if (index in _langkahInputs.indices) {
            _langkahInputs.removeAt(index)
            _langkahInputs.forEachIndexed { i, langkah ->
                _langkahInputs[i] = langkah.copy(nomor = i + 1)
            }
            addRecipeState = addRecipeState.copy(langkah = _langkahInputs.toList())
        }
    }

    fun storeRecipeContent(context: Context, dataStoreManager: DataStoreManager) {
        isLoading = true
        uploadSuccessMessage = null
        uploadErrorMessage = null

        val originalVideo = addRecipeState.video

        if (originalVideo != null) {
            VideoUtils.compressVideo(
                context = context,
                inputUri = originalVideo,
                onSuccess = { compressedUri ->
                    addRecipeState = addRecipeState.copy(video = compressedUri)
                    performUpload(context, dataStoreManager)
                },
                onFailure = { error ->
                    isLoading = false
                    uploadErrorMessage = error
                }
            )
        } else {
            performUpload(context, dataStoreManager)
        }
    }

    fun preparedPendingUpload(userId: Int) {
        val uploadingRecipe = RecipeContentResponse(
            id_resep = -1,
            id_user = userId,
            judul_konten = addRecipeState.judul,
            deskripsi_konten = addRecipeState.deskripsi,
            durasi = addRecipeState.durasi.toIntOrNull() ?: 0,
            kategori = addRecipeState.kategori,
            status_konten = "Uploading",
            thumbnail = null,
            video_tutorial = null,
            terbuka_di_level = 0,
            created_at = "",
            updated_at = "",
            bahan_resep_table = listOf(),
            langkah_langkah_table = listOf(),
            gizi_table = listOf()
        )
        this.uploadingRecipe = uploadingRecipe
        uploadProgress = 0.01f
        _recipeList.value = listOf(uploadingRecipe ) + _recipeList.value
    }

    fun uploadContent(recipeId: Int){
        viewModelScope.launch {
            isLoading = true
            try {
                val body = mapOf("status_konten" to "Terunggah")
                val response = BisaMasakInstance.bisaMasakService.updateContentStatus(recipeId, body)
                if (response.isSuccessful) {
                    uploadSuccessMessage = "Konten anda berhasil diunggah!"
                    recipeDetails(recipeId)
                } else {
                    uploadErrorMessage = response.errorBody()?.string() ?: "Gagal update status"
                }
            } catch (e: Exception) {
                uploadErrorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }

    private fun performUpload(context: Context, dataStoreManager: DataStoreManager) {
        viewModelScope.launch {
            try {
                val userId = dataStoreManager.getUserId().toInt()
                preparedPendingUpload(userId)
                delay(500)

                val currentLangkah = _langkahInputs.toList()
                addRecipeState = addRecipeState.copy(
                    bahan = ingredientInputs.toList(),
                    langkah = currentLangkah
                )

                val idUserPart = userId.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                val thumbnailPart = addRecipeState.thumbnail?.let {
                    prepareFilePart("thumbnail", it, context)
                }

                val response = BisaMasakInstance.bisaMasakService.storeContentRecipe(
                    id_user = idUserPart,
                    judul = stringPart(addRecipeState.judul),
                    deskripsi = stringPart(addRecipeState.deskripsi),
                    durasi = stringPart(addRecipeState.durasi),
                    kategori = stringPart(addRecipeState.kategori),
                    thumbnail = thumbnailPart,
                    video_tutorial = addRecipeState.video?.let {
                        prepareFilePart("video_tutorial", it, context) { progress ->
                            uploadProgress = progress
                        }
                                                               },
                    bahan = createBahanParts(addRecipeState.bahan),
                    langkah = createLangkahParts(addRecipeState.langkah, context)
                )

                if (response.isSuccessful) {
                    uploadSuccessMessage = "Resep berhasil diunggah!"
                    navigateAfterUpload = true
                    recipe()
                    var attempts = 0
                    val maxAttempts = 20
                    while (attempts < maxAttempts) {
                        val found = allRecipeList.value.any {
                            it.judul_konten == addRecipeState.judul && it.status_konten == "Terunggah"
                        }
                        if (found) break
                        delay(250)
                        _recipeList.value = _recipeList.value.filterNot { it.id_resep == -1 && it.status_konten == "Uploading" }
                        uploadingRecipe = null
                        uploadProgress = 0f
                        recipe()
                        attempts++
                    }
                } else {
                    uploadErrorMessage = response.errorBody()?.string() ?: "Gagal mengunggah resep."
                }
            } catch (e: Exception) {
                uploadErrorMessage = e.localizedMessage ?: "Terjadi kesalahan saat upload."
            } finally {
                isLoading = false
            }
        }
    }

//    Update Recipe
    fun updateRecipeContent(context: Context) {
    viewModelScope.launch {
        isLoading = true
        uploadSuccessMessage = null
        uploadErrorMessage = null

        try {
            val recipeId = editingRecipeId ?: return@launch
            val currentLangkah = _langkahInputs.toList()
            addRecipeState = addRecipeState.copy(
                bahan = ingredientInputs.toList(),
                langkah = currentLangkah
            )

            val thumbnailPart = addRecipeState.thumbnail?.let {
                prepareFilePart("thumbnail", it, context)
            }

            val videoPart = addRecipeState.video?.let {
                prepareFilePart("video_tutorial", it, context)
            }

            val response = BisaMasakInstance.bisaMasakService.updateContentRecipe(
                id = recipeId,
                judul = stringPart(addRecipeState.judul),
                deskripsi = stringPart(addRecipeState.deskripsi),
                durasi = stringPart(addRecipeState.durasi),
                kategori = stringPart(addRecipeState.kategori),
                thumbnail = thumbnailPart,
                video_tutorial = videoPart,
                bahan = createBahanParts(addRecipeState.bahan),
                langkah = createLangkahParts(addRecipeState.langkah, context)
            )

            if (response.isSuccessful) {
                uploadSuccessMessage = "Konten berhasil diperbarui!"
                isEditMode = false
                editingRecipeId = null
                navigateAfterUpload = true
                recipe()
            } else {
                uploadErrorMessage = response.errorBody()?.string() ?: "Gagal memperbarui konten."
            }
        } catch (e: Exception) {
            uploadErrorMessage = e.localizedMessage ?: "Terjadi kesalahan saat update."
        } finally {
            isLoading = false
        }
    }
}

    fun startEditingContent(content: RecipeContentResponse) {
        if (addRecipeState.judul.isNotBlank()) return

        isEditMode = true
        editingRecipeId = content.id_resep

        addRecipeState = addRecipeState.copy(
            judul = content.judul_konten,
            deskripsi = content.deskripsi_konten,
            durasi = content.durasi.toString(),
            kategori = content.kategori
        )

        if (ingredientInputs.isEmpty()) {
            content.bahan_resep_table.forEach {
                ingredientInputs.add(
                    IngredientInput(
                        idBahan = it.id_bahan,
                        namaBahan = it.bahan_masak_table?.nama_bahan ?: "",
                        jumlah = it.jumlah_bahan,
                        satuan = it.satuan_bahan
                    )
                )
            }
        }

        if (_langkahInputs.isEmpty()) {
            content.langkah_langkah_table.forEachIndexed { index, langkah ->
                _langkahInputs.add(
                    LangkahInput(
                        nomor = index + 1,
                        deskripsi = langkah.deskripsi_langkah,
                        imageUri = null,
                        existingImageUrl = langkah.gambar_langkah
                    )
                )
            }
        }

        addRecipeState = addRecipeState.copy(
            bahan = ingredientInputs.toList(),
            langkah = _langkahInputs.toList()
        )
    }

//    Delete Recipe
    fun deleteRecipe(recipeId: Int, onSuccess: () -> Unit = {}, onError: (String) -> Unit = {}) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = BisaMasakInstance.bisaMasakService.deleteContentRecipe(recipeId)
                if (response.isSuccessful) {
                    _recipeList.value = _recipeList.value.filterNot { it.id_resep == recipeId }
                    onSuccess()
                } else {
                    val errorMsg = response.errorBody()?.string() ?: "Gagal menghapus resep"
                    onError(errorMsg)
                }
            } catch (e: Exception) {
                onError(e.localizedMessage ?: "Terjadi kesalahan saat menghapus resep")
            } finally {
                isLoading = false
            }
        }
    }

    private fun stringPart(value: String): RequestBody = value.toRequestBody("text/plain".toMediaTypeOrNull())

    private fun createBahanParts(list: List<IngredientInput>): List<MultipartBody.Part> {
        return list.flatMapIndexed { index, input ->
            listOfNotNull(
                input.idBahan?.let {
                    MultipartBody.Part.createFormData("bahan[$index][id_bahan]", it.toString())
                },
                MultipartBody.Part.createFormData("bahan[$index][jumlah_bahan]", input.jumlah),
                MultipartBody.Part.createFormData("bahan[$index][satuan_bahan]", input.satuan)
            )
        }
    }

    private fun createLangkahParts(list: List<LangkahInput>, context: Context): List<MultipartBody.Part> {
        return list.flatMapIndexed { index, langkah ->
            buildList {
                add(MultipartBody.Part.createFormData("langkah[$index][nomor_langkah]", langkah.nomor.toString()))
                add(MultipartBody.Part.createFormData("langkah[$index][deskripsi_langkah]", langkah.deskripsi))
                langkah.imageUri?.let {
                    val compressedFile = compressImage(context, it)
                    add(
                        MultipartBody.Part.createFormData(
                            name = "langkah[$index][gambar_langkah]",
                            filename = compressedFile.name,
                            body = compressedFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
                        )
                    )
                }

                if (langkah.imageUri == null && langkah.existingImageUrl != null) {
                    add(
                        MultipartBody.Part.createFormData(
                            "langkah[$index][existing_image_url]",
                            langkah.existingImageUrl
                        )
                    )
                }
            }
        }
    }

    fun clearUploadSuccessMessage() {
        uploadSuccessMessage = null
    }

    fun resetAddRecipe() {
        addRecipeState = AddRecipeState()
        ingredientInputs.clear()
        _langkahInputs.clear()
        isEditMode = false
        editingRecipeId = null
    }

    fun resetNavigateAfterUpload() {
        navigateAfterUpload = false
    }

}

data class AddRecipeState(
    val judul: String = "",
    val deskripsi: String = "",
    val durasi: String = "",
    val kategori: String = "",
    val thumbnail: Uri? = null,
    val video: Uri? = null,
    val bahan: List<IngredientInput> = emptyList(),
    val langkah: List<LangkahInput> = emptyList()
)

data class IngredientInput(
    val idBahan: Int? = null,
    val namaBahan: String = "",
    val jumlah: String = "",
    val satuan: String = ""
)

data class LangkahInput(
    val nomor: Int,
    var deskripsi: String = "",
    val imageUri: Uri? = null,
    val existingImageUrl: String? = null
)

enum class LoadingState {
    Idle,
    Loading,
    Editing,
}