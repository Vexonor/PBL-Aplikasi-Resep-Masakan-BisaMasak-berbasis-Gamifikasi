package com.example.bisamasak.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bisamasak.R
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.profile.add_content.TextInput
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import kotlin.toString

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedBoxWithConstraintsScope")
@Composable
fun MenuDetailScreen(
    recipeId: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RecipeContentViewModel = viewModel(),
) {
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
    val isLoading = viewModel.isLoading

    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(recipeId) {
        viewModel.recipeDetails(recipeId)
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
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0x66FAFAFA),
                    navigationIconContentColor = Color.Transparent,
                    actionIconContentColor = Color.Transparent
                ),
            )
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
                            model = "http://192.168.100.97:8000/storage/${menudetails?.thumbnail ?: ""}",
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
                                        Text(
                                            text = menudetails?.judul_konten.toString(),
                                            style = OutfitTypography.titleLarge,
                                            modifier = Modifier
                                                .width(250.dp)
                                        )
                                        Row (
                                            modifier = Modifier
                                                .wrapContentWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.ic_timer),
                                                contentDescription = "Timer",
                                                modifier = Modifier
                                                    .size(20.dp)
                                            )
                                            Text(
                                                text = "${menudetails?.durasi} menit",
                                                style = OutfitTypography.labelLarge
                                            )
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .height(200.dp)
                                            .padding(horizontal = 24.dp)
                                            .verticalScroll(rememberScrollState())
                                    ) {
                                        Text(
                                            text = menudetails?.deskripsi_konten.orEmpty(),
                                            style = OutfitTypography.bodyLarge
                                        )
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Portion
                            item {
                                val customTextHandle = TextSelectionColors(
                                    handleColor = Color(0xFFED453A),
                                    backgroundColor = Color.Transparent
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Porsi",
                                        style = OutfitTypography.titleLarge,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Row(
                                        modifier = Modifier
                                            .wrapContentWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                                    ) {
                                        Button(
                                            onClick = {
                                                if (portion > 1) {
                                                    portion--
                                                    portionToText = portion.toString()
                                                }
                                            },
                                            colors = ButtonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = Color.Black,
                                                disabledContainerColor = Color.Transparent,
                                                disabledContentColor = Color.Black
                                            )
                                        ) {
                                            Text(
                                                text = "-",
                                                style = OutfitTypography.titleLarge
                                            )
                                        }
                                        CompositionLocalProvider(LocalTextSelectionColors provides customTextHandle) {
                                            TextField(
                                                value = portionToText,
                                                onValueChange = { newValue ->
                                                    if (newValue.all { it.isDigit() }) {
                                                        portionToText = newValue
                                                        val parsed = newValue.toIntOrNull()
                                                        if (parsed != null && parsed in 1..50) {
                                                            portion = parsed
                                                        }
                                                    }
                                                },
                                                textStyle = OutfitTypography.titleLarge.copy(
                                                    textAlign = TextAlign.Center
                                                ),
                                                singleLine = true,
                                                keyboardOptions = KeyboardOptions.Default.copy(
                                                    keyboardType = KeyboardType.Number
                                                ),
                                                colors = TextFieldDefaults.colors(
                                                    unfocusedContainerColor = Color.Transparent,
                                                    focusedContainerColor = Color.Transparent,
                                                    focusedIndicatorColor = Color.Black,
                                                    unfocusedIndicatorColor = Color.Transparent,
                                                    cursorColor = Color(0xFFED453A),

                                                    ),
                                                modifier = Modifier
                                                    .width(60.dp)
                                            )
                                        }
                                        Button(
                                            onClick = {
                                                if (portion < 50) {
                                                    portion++
                                                    portionToText = portion.toString()
                                                }
                                            },
                                            colors = ButtonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = Color.Black,
                                                disabledContainerColor = Color.Transparent,
                                                disabledContentColor = Color.Black
                                            )
                                        ) {
                                            Text(
                                                text = "+",
                                                style = OutfitTypography.titleLarge
                                            )
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Nutrition
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Nutrisi",
                                        style = OutfitTypography.titleLarge
                                    )
                                    LazyHorizontalGrid(
                                        rows = GridCells.Fixed(3),
                                        modifier = Modifier
                                            .fillMaxSize()
                                    ) {
                                        items(menudetails?.gizi_table ?: emptyList()) { nutrient->
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
                                                        .padding(4.dp)
                                                ) {
                                                    Text(
                                                        text = nutrient.nama_gizi,
                                                        style = OutfitTypography.labelLarge
                                                    )
                                                    val nutrientAmount = nutrient.jumlah.toFloatOrNull()?.times(portion)
                                                    Text(
                                                        text = if (nutrientAmount != null) "± ${nutrientAmount.toInt()} ${nutrient.satuan}" else "${nutrient.jumlah} ${nutrient.satuan}",
                                                        style = OutfitTypography.labelMedium
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Ingredients
                            item {
                                val totalIngredients = menudetails?.bahan_resep_table?.size ?: 0
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Bahan-bahan",
                                            style = OutfitTypography.titleLarge,
                                            modifier = Modifier.padding(vertical = 12.dp)
                                        )
                                        Text(
                                            text = "$totalIngredients Bahan",
                                            style = OutfitTypography.labelLarge,
                                            color = Color.Gray
                                        )
                                    }
                                    Column(
                                        modifier = Modifier
                                    ){
                                        menudetails?.bahan_resep_table?.forEach { ingredient ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = ingredient.bahan_masak_table?.nama_bahan?.replaceFirstChar { it.uppercase() } ?: "Tidak Ada Nama Bahan",
                                                    style = OutfitTypography.labelLarge
                                                )
                                                Row(
                                                    modifier = Modifier
                                                        .wrapContentWidth(),
                                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                                ) {
                                                    val jumlahDasar = parseFractionalAmount(ingredient.jumlah_bahan)
                                                    val jumlahPerPorsi = jumlahDasar?.times(portion)
                                                    Text(
                                                        text = jumlahPerPorsi?.toString() ?: ingredient.jumlah_bahan,
                                                        style = OutfitTypography.labelLarge
                                                    )
                                                    Text(
                                                        text = ingredient.satuan_bahan.replaceFirstChar { it.uppercase() },
                                                        style = OutfitTypography.labelLarge,
                                                        textAlign = TextAlign.End,
                                                        modifier = Modifier
                                                            .width(80.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Video
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Video Tutoral",
                                        style = OutfitTypography.titleLarge,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Text(
                                            text = "Tidak ada video tutorial untuk resep ini",
                                            style = OutfitTypography.titleMedium,
                                            color = Color.LightGray
                                        )
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Tutorial
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Cara Memasak Resep Ini",
                                            style = OutfitTypography.titleLarge,
                                            modifier = Modifier.padding(vertical = 12.dp)
                                        )
                                        Button(
                                            onClick = {
                                                navController.navigate("tutorial_detail/${recipeId}")
                                            },
                                            colors = ButtonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = Color(0xE6ED453A),
                                                disabledContainerColor = Color.Transparent,
                                                disabledContentColor = Color.Transparent
                                            ),
                                            contentPadding = PaddingValues(0.dp)
                                        ) {
                                            Text(
                                                text = "Lihat Semua",
                                                style = OutfitTypography.labelLarge
                                            )
                                        }
                                    }
                                    LazyRow(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ){
                                        val steps = menudetails?.langkah_langkah_table ?: emptyList()
                                        items(steps) { step ->
                                            Column(
                                                modifier = Modifier
                                                    .width(300.dp)
                                                    .height(250.dp)
                                                    .padding(horizontal = 12.dp),
                                                verticalArrangement = Arrangement.spacedBy(12.dp)
                                            ) {
                                                AsyncImage(
                                                    model = "http://192.168.100.97:8000/storage/${step.gambar_langkah ?: ""}",
                                                    contentDescription = step.nomor_langkah.toString(),
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .clip(RoundedCornerShape(8.dp))
                                                )
                                                Text(
                                                    text = "Langkah ${step.nomor_langkah}",
                                                    style = OutfitTypography.labelLarge
                                                )
                                                Text(
                                                    text = step.deskripsi_langkah,
                                                    style = OutfitTypography.bodyMedium,
                                                    maxLines = 2,
                                                    modifier = Modifier
                                                        .height(50.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Category
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Kategori",
                                        style = OutfitTypography.titleLarge,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                    LazyHorizontalGrid(
                                        rows = GridCells.Fixed(2),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp),
                                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                                        verticalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        item {
                                            Card(
                                                colors = CardDefaults.cardColors(
                                                    containerColor = Color.Transparent,
                                                    contentColor = Color(0xFFED453A)
                                                ),
                                                border = BorderStroke(1.dp, Color(0xFFED453A)),
                                                shape = RoundedCornerShape(percent = 50),
                                                modifier = Modifier
                                                    .wrapContentSize()
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .width(150.dp)
                                                        .height(50.dp)
                                                        .padding(horizontal = 16.dp),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        text = menudetails?.kategori?.replaceFirstChar { it.uppercase() } ?: "Tidak Ada Kategori",
                                                        style = OutfitTypography.titleMedium,
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Comment Section
                            item {
                                var text by remember { mutableStateOf("") }

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Komentar",
                                        style = OutfitTypography.titleLarge,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 12.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(0.4f)
                                                .size(50.dp)
                                                .clip(RoundedCornerShape(50.dp))
                                                .background(Color(0xFFED453A)),
                                            contentAlignment = Alignment.Center
                                        ){
                                            Text(
                                                text = "S",
                                                style = OutfitTypography.displaySmall,
                                                color = Color.White
                                            )
                                        }
                                        OutlinedTextField(
                                            value = text ,
                                            onValueChange = { text = it },
                                            placeholder = {
                                                Text(
                                                    text = "Tuliskan Komentar Anda...",
                                                    style = OutfitTypography.bodyMedium
                                                )
                                            },
                                            colors = OutlinedTextFieldDefaults.colors(
                                                unfocusedBorderColor = Color(0xFFED453A),
                                                focusedBorderColor = Color(0xFFED453A),
                                                cursorColor = Color(0xFFED453A)
                                            ),
                                            textStyle = TextStyle(fontFamily = OutfitFont),
                                            singleLine = false,
                                            shape = RoundedCornerShape(32.dp),
                                            modifier = Modifier
                                                .weight(2f)
                                                .fillMaxWidth()
                                                .height(44.dp)
                                                .padding(horizontal = 12.dp),
                                        )
                                        Button(
                                            modifier = Modifier
                                                .weight(0.5f),
                                            onClick = {  },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFFED453A),
                                                contentColor = Color.White,
                                                disabledContainerColor = Color.Transparent,
                                                disabledContentColor = Color.Transparent
                                            ),
                                        ) {
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Filled.Send,
                                                contentDescription = "Send",
                                                tint = Color.White,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    color = Color(0xFF748189)
                                )
                            }
//                     Similar Recipe
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Resep Masakan Terkait",
                                        style = OutfitTypography.titleLarge,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )

                                    if (similarRecipes.isEmpty()) {
                                        Text(
                                            text = "Tidak ada resep yang serupa",
                                            style = OutfitTypography.bodyMedium,
                                            color = Color.Gray
                                        )
                                    } else {
                                        val onRecipeClick: (Int) -> Unit = { recipeId ->
                                            navController.navigate("recipe_detail/$recipeId")
                                        }
                                        LazyRow {
                                            items(similarRecipes) { recipe ->
                                                RecipeCard(
                                                    foodImg = "http://192.168.100.97:8000/storage/${recipe.thumbnail ?: ""}",
                                                    foodName = recipe.judul_konten,
                                                    duration = recipe.durasi.toString(),
                                                    modifier = Modifier
                                                        .clickable {
                                                            onRecipeClick(recipe.id_resep)
                                                        }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
//                      Report Dialog
                        if (showDialog) {
                            AlertDialog(
                                onDismissRequest = { showDialog = false },
                                confirmButton = {
                                    TextButton(onClick = {
                                        showDialog = false
                                    }) {
                                        Text(
                                            text = "Kirim Laporan",
                                            style = OutfitTypography.labelLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFFED453A)
                                        )
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showDialog = false }) {
                                        Text(
                                            text = "Batal",
                                            style = OutfitTypography.labelLarge,
                                            color = Color.Black
                                        )
                                    }
                                },
                                containerColor = Color.White,
                                title = {
                                    Text(
                                        text = "Laporkan Konten",
                                        style = OutfitTypography.titleLarge
                                    )
                                },
                                text = {
                                    Column(
                                        modifier = Modifier.heightIn(max = 200.dp) ,
                                        verticalArrangement = Arrangement.spacedBy(20.dp)
                                    ) {
                                        Text(
                                            text = "Mohon hanya untuk melaporkan komentar yang mengandung iklan, ujaran kebencian atau konten lain yang tidak berhubungan dengan memasak. Tim BisaMasak akan segera menindak-lajutin laporan ini.",
                                            style = OutfitTypography.bodyMedium
                                        )
                                        TextInput(
                                            label = "Tuliskan Alasan",
                                            singleLine = false,
                                            keyboardType = KeyboardType.Text
                                        )
                                    }
                                }
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