package com.example.bisamasak.data.service

import com.example.bisamasak.data.dataContainer.CommentResponse
import com.example.bisamasak.data.dataContainer.CommentStore
import com.example.bisamasak.data.dataContainer.IngredientResponse
import com.example.bisamasak.data.dataContainer.LoginRequest
import com.example.bisamasak.data.dataContainer.LoginResponse
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.dataContainer.RegisterRequest
import com.example.bisamasak.data.dataContainer.RegisterResponse
import com.example.bisamasak.data.dataContainer.ReportResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface BisaMasakService {
//    Register
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

//    Login
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

//    Recipe Content
    @GET("konten-tutorial")
    suspend fun recipeContent(): List<RecipeContentResponse>

    @GET("search")
    suspend fun searchRecipes(@Query("q") keywords: List<String>): List<RecipeContentResponse>

    @Multipart
    @POST("konten-tutorial")
    suspend fun storeContentRecipe(
        @Part("id_user") id_user: RequestBody,
        @Part("judul_konten") judul: RequestBody,
        @Part("deskripsi_konten") deskripsi: RequestBody,
        @Part("durasi") durasi: RequestBody,
        @Part("kategori") kategori: RequestBody,
        @Part thumbnail: MultipartBody.Part?,
        @Part video_tutorial: MultipartBody.Part?,
        @Part bahan: List<MultipartBody.Part>,
        @Part langkah: List<MultipartBody.Part>
    ): Response<ResponseBody>

    @PATCH("konten-tutorial/{id}/status")
    suspend fun updateContentStatus(
        @Path("id") id: Int,
        @Body body: Map<String, String>
    ): Response<Unit>

//    Ingredient
    @GET("bahan-masak")
    suspend fun ingredient(): List<IngredientResponse>
    @GET("bahan-masak/{id_bahan}")
    suspend fun ingredientDetail(@Path("id_bahan") id_bahan: Int): IngredientResponse

//    Report Content
    @POST("laporan-konten")
    suspend fun reportContent(@Body report: ReportResponse): Response<Unit>

//    Comment
    @GET("komentar/resep/{id_resep}")
    suspend fun getCommentsByRecipeId(@Path("id_resep") idResep: Int): List<CommentResponse>

    @POST("komentar")
    suspend fun storeComment(@Body comment: CommentStore): Response<CommentResponse>

    @DELETE("komentar/{id}")
    suspend fun deleteComment(@Path("id") id: Int): Response<Unit>
}