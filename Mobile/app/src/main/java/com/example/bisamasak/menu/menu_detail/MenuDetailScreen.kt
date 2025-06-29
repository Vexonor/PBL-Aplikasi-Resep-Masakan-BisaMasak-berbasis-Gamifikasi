package com.example.bisamasak.menu.menu_detail

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bisamasak.R
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.data.utils.videoUrl
import com.example.bisamasak.data.viewModel.CommentViewModel
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.data.viewModel.ReportViewModel
import com.example.bisamasak.data.viewModel.SaveRecipeViewModel
import com.example.bisamasak.ui.theme.OutfitTypography
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedBoxWithConstraintsScope",
    "UnrememberedGetBackStackEntry"
)
@Composable
fun MenuDetailScreen(
    recipeId: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RecipeContentViewModel = viewModel(),
    reportViewModel: ReportViewModel = viewModel()
) {
//    User Data
    val context = LocalContext.current
    val dataStoreManager = remember { DataStoreManager(context) }
    var userId by remember { mutableStateOf(-1L) }
    var isUserLoaded by remember { mutableStateOf(false) }
    val userName = remember { mutableStateOf("") }

//    Saved Recipe
    val saveRecipeViewModel: SaveRecipeViewModel = viewModel()
    val isSaved by saveRecipeViewModel.isSaved.collectAsState()

//    Recipe Content
    val menudetails = viewModel.selectedRecipe
    val similarRecipes by remember(menudetails) {
        derivedStateOf {
            if (menudetails != null) {
                viewModel.similarRecipe(
                    recipeId,
                    menudetails.bahan_resep_table
                )
            } else {
                emptyList()
            }
        }
    }
    val uploadSuccessMessage = viewModel.uploadSuccessMessage

    val isLoading = viewModel.isLoading

    var showDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

//    Report Content
    var reportText by remember { mutableStateOf("") }
    val reportSuccess = reportViewModel.isSuccess
    val reportError = reportViewModel.errorMessage

    LaunchedEffect(Unit) {
        val id = dataStoreManager.getUserId()
        val name = dataStoreManager.getUserName()
        userId = id
        userName.value = name
        isUserLoaded = true
    }

    LaunchedEffect(recipeId) {
        viewModel.recipeDetails(recipeId)
    }

    LaunchedEffect(reportSuccess, reportError) {
        if (reportSuccess) {
            Toast.makeText(context, "Laporan berhasil dikirim", Toast.LENGTH_SHORT).show()
            showDialog = false
            reportText = ""
            reportViewModel.resetStatus()
        }

        if (reportError != null) {
            Toast.makeText(context, reportError, Toast.LENGTH_SHORT).show()
            reportViewModel.resetStatus()
        }
    }

    LaunchedEffect(uploadSuccessMessage) {
        uploadSuccessMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            navController.navigate("profile_screen?tab=recipe") {
                popUpTo("recipe_detail/$recipeId") { inclusive = true }
            }
            viewModel.clearUploadSuccessMessage()
        }
    }

    LaunchedEffect(isUserLoaded, recipeId) {
        if (isUserLoaded && userId != -1L) {
            saveRecipeViewModel.checkSaved(userId.toInt(), recipeId)
        }
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {},
                modifier = modifier,
                navigationIcon = {
                    Button(
                        onClick = {
                            navController.popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        elevation = null
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFFED453A),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    if (menudetails?.status_konten == "Terunggah" && menudetails.id_user != userId.toInt()) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
//                        Report Button
                        Button(
                            onClick = { showDialog = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp),
                            elevation = null
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_warning),
                                contentDescription = "Report",
                                modifier = Modifier.size(24.dp)
                            )
                        }
//                        Save Button
                        Button(
                            onClick = {
                                if (isSaved) {
                                    saveRecipeViewModel.deleteSavedRecipe(userId.toInt(), recipeId)
                                    Toast.makeText(context, "Dihapus dari simpanan", Toast.LENGTH_SHORT).show()
                                } else {
                                    saveRecipeViewModel.saveRecipe(userId.toInt(), recipeId)
                                    Toast.makeText(context, "Disimpan ke favorit", Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp),
                            elevation = null
                        ) {
                            Icon(
                                imageVector = if (isSaved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Save",
                                tint = Color(0xFFED453A),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    } else if (menudetails?.status_konten != "Terunggah" && menudetails?.id_user == userId.toInt()) {
                        Button(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .width(100.dp),
                            onClick = {
                                menudetails.let { recipe ->
                                    viewModel.uploadContent(recipe.id_resep)
                                    Toast.makeText(context, "Mengunggah konten...", Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFED453A),
                                contentColor = Color.White,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp),
                            elevation = null,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Unggah",
                                style = OutfitTypography.labelLarge
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0x66FAFAFA),
                    navigationIconContentColor = Color.Transparent,
                    actionIconContentColor = Color.Transparent
                ),
            )
        },
        floatingActionButton = {
            if (menudetails?.id_user == userId.toInt()) {
                FloatingMenu(
                    isDraft = menudetails.status_konten != "Terunggah",
                    onEditClick = {
                        menudetails.let { content ->
                            viewModel.startEditingContent(content)
                            viewModel.resetNavigateAfterUpload()
                            viewModel.clearUploadSuccessMessage()
                            navController.navigate("add_content_screen?mode=edit&id=${menudetails.id_resep}")
                        }
                    },
                    onDeleteClick = { showDeleteDialog = true }
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            color = Color.White
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val screenHeight = maxHeight
                val imageHeight = screenHeight * 0.4f
                val offsetY = imageHeight * 0.5f

                val density = LocalDensity.current
                val offsetYPx = with(density) { offsetY.toPx().toInt() }
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ){
                    if (isLoading) {
                        LoadingContent(
                            innerPadding = innerPadding,
                            imageHeight = imageHeight,
                            offsetYPx = offsetYPx
                        )
                    }
                    else {
                        var portion by rememberSaveable { mutableIntStateOf(1) }
                        var portionToText by rememberSaveable { mutableStateOf(portion.toString()) }

                        AsyncImage(
                            model = menudetails?.imageUrl,
                            contentDescription = menudetails?.judul_konten,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .scale(1.35f)
                                .height(imageHeight)
                        )
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .offset { IntOffset(x = 0, y = offsetYPx) }
                                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                                .background(Color.White),
                            contentPadding = PaddingValues(bottom = 200.dp)
                        ) {
//                     Title & Description
                            item {
                                HeaderSection(menudetails = menudetails)
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Portion
                            item {
                                PortionSection(
                                    portion = portion,
                                    portionText = portionToText,
                                    onPortionTextChange = { newValue ->
                                        if (newValue.all { it.isDigit() }) {
                                            portionToText = newValue
                                            newValue.toIntOrNull()?.let {
                                                if (it in 1..20) portion = it
                                            }
                                        }
                                    },
                                    onIncrease = {
                                        if (portion < 20) {
                                            portion++
                                            portionToText = portion.toString()
                                        }
                                    },
                                    onDecrease = {
                                        if (portion > 1) {
                                            portion--
                                            portionToText = portion.toString()
                                        }
                                    }
                                )
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Nutrition
                            item {
                                val nutritionList = menudetails?.gizi_table ?: emptyList()
                                if (nutritionList.isNotEmpty()) {
                                NutritionSection(
                                    nutritionList = nutritionList,
                                    portion = portion
                                )
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                                }
                            }
//                     Ingredients
                            item {
                                val ingredients = menudetails?.bahan_resep_table ?: emptyList()
                                IngredientSection(
                                    ingredients = ingredients,
                                    portion = portion
                                )
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Video
                            item {
                                VideoTutorialSection(videoUrl = menudetails?.videoUrl)
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Tutorial
                            item {
                                val steps = menudetails?.langkah_langkah_table ?: emptyList()
                                TutorialSection(
                                    steps = steps,
                                    recipeId = recipeId,
                                    navController = navController
                                )
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Category
                            item {
                                CategorySection(
                                    category = menudetails?.kategori
                                )
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Comment Section
                            if (menudetails?.status_konten == "Terunggah") {
                            if (!isUserLoaded) {
                                item {
                                    Text("Memuat komentar...", modifier = Modifier.padding(24.dp))
                                }
                            } else {
                                item {
                                    val commentViewModel: CommentViewModel = viewModel()
                                    CommentSection(
                                        recipeId = recipeId,
                                        userId = userId.toInt(),
                                        userName = userName.value,
                                        viewModel = commentViewModel
                                    )
                                    HorizontalDivider(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 24.dp),
                                        color = Color(0xFF748189)
                                    )
                                }
                            }
                            }
//                     Similar Recipe
                            item {
                                if (menudetails?.status_konten == "Terunggah") {
                                SimilarRecipeSection(
                                    similarRecipes = similarRecipes,
                                    onRecipeClick = { recipeId ->
                                        navController.navigate("recipe_detail/$recipeId")
                                    }
                                )
                                }
                            }
                        }
//                      Report Dialog
                        if (showDialog) {
                            ReportDialog(
                                onDismiss = { showDialog = false },
                                recipeId = recipeId,
                                reportViewModel = reportViewModel
                            )
                        }
//                      Delete Dialog
                        if (showDeleteDialog) {
                            DeleteDialog(
                                onDismiss = { showDeleteDialog = false },
                                onConfirmDelete = {
                                    viewModel.deleteRecipe(
                                        recipeId = recipeId,
                                        onSuccess = {
                                            Toast.makeText(context, "Resep berhasil dihapus", Toast.LENGTH_SHORT).show()
                                            navController.navigate("profile_screen?tab=recipe") {
                                                popUpTo("recipe_detail/$recipeId") { inclusive = true }
                                            }
                                        },
                                        onError = {
                                            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                        }
                                    )
                                },
                                isDeleting = viewModel.isLoading
                            )
                        }

                    }
                }
            }
        }
    }
}

fun parseFractionalAmount(input: String): Double? {
    val trimmed = input.trim()

    trimmed.toDoubleOrNull()?.let { return it }

    if (trimmed.contains("/") && !trimmed.contains(" ")) {
        val parts = trimmed.split("/")
        if (parts.size == 2) {
            val numerator = parts[0].toDoubleOrNull()
            val denominator = parts[1].toDoubleOrNull()
            if (numerator != null && denominator != null && denominator != 0.0) {
                return numerator / denominator
            }
        }
    }

    if (trimmed.contains(" ")) {
        val parts = trimmed.split(" ")
        if (parts.size == 2) {
            val whole = parts[0].toDoubleOrNull()
            val fraction = parseFractionalAmount(parts[1])
            if (whole != null && fraction != null) {
                return whole + fraction
            }
        }
    }

    return null
}

@Composable
fun LoadingContent(innerPadding: PaddingValues, imageHeight: Dp, offsetYPx: Int) {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.View)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(1.35f)
            .height(imageHeight)
            .shimmer(shimmer)
            .background(Color(0xFFF0F0F0))
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .offset { IntOffset(x = 0, y = offsetYPx) }
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color(0XFFFAFAFA)),
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .shimmer(shimmer)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.LightGray)
                )
                Row (
                    modifier = Modifier
                        .width(100.dp)
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .shimmer(shimmer)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .shimmer(shimmer)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.LightGray)
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            color = Color(0xFF748189)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(vertical = 16.dp)
                .shimmer(shimmer)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            color = Color(0xFF748189)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .shimmer(shimmer)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            )
            LazyHorizontalGrid(
                rows = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(9) {
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .wrapContentHeight(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(40.dp)
                                    .shimmer(shimmer)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.LightGray)
                            )
                        }
                    }
                }
            }
        }
    }
}