package com.example.bisamasak.ingredient

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.platform.LocalConfiguration
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.viewModel.IngredientViewModel
import androidx.compose.foundation.lazy.grid.items
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.ui.theme.OutfitTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientDetailScreen(
    ingredientId: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: IngredientViewModel = viewModel(),
    userLevel: Int
) {
//    Sheet State
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val animatedScale by animateDpAsState(
        targetValue = if (showBottomSheet) {
            300.dp
        } else {
            LocalConfiguration.current.screenHeightDp.dp
        },
        label = "Image Height"
    )
    val imageSizeModifier = Modifier
        .fillMaxWidth()
        .height(animatedScale)

    val detail = viewModel.ingredientDetail
    val isLoading = viewModel.isLoading

    LaunchedEffect(ingredientId) {
        viewModel.ingredientDetail(ingredientId)
    }

    LaunchedEffect(detail?.nama_bahan) {
        detail?.nama_bahan?.let {
            viewModel.recipeByIngredient(it)
        }
    }

        Scaffold(
            containerColor = Color.White,
            topBar = {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 24.dp, top = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            navController.navigate("ingredient_screen")
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
                }
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    icon = { Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "") },
                    text = {
                        Text(
                            text = "Lihat Informasi Bahan Masak",
                            style = OutfitTypography.labelLarge
                        )
                           },
                    onClick = {
                        showBottomSheet = true
                    },
                    containerColor = Color(0xFFFAFAFA)
                )
            }
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp),
                color = Color.White
            ) {
                if (isLoading || detail == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }else {
                    Box(
                        modifier = imageSizeModifier
                    ){
                        AsyncImage(
                            model = detail.gambar_bahan,
                            contentDescription = detail.nama_bahan,
                            modifier = imageSizeModifier
                        )
                    }
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                            },
                            sheetState = sheetState,
                            containerColor = Color.White,
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            Column (
                                modifier = Modifier
                                    .padding(horizontal = 24.dp)
                            ) {
//                                Title & Description Section
                                Column (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .heightIn(min = 80.dp, max = 200.dp)
                                        .padding(vertical = 12.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Text(
                                        text = detail.nama_bahan.replaceFirstChar { it.uppercase() },
                                        style = OutfitTypography.titleLarge
                                    )
                                    Text(
                                        text = detail.deskripsi_bahan,
                                        style = OutfitTypography.bodyLarge
                                    )
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
//                                Nutrition Section
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                        .padding(vertical = 12.dp)
                                ) {
                                    Text(
                                        text = "Nutrisi",
                                        style = OutfitTypography.titleLarge
                                    )
                                    LazyHorizontalGrid(
                                        rows = GridCells.Fixed(3),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        items(detail.gizi_table) {  gizi ->
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
                                                        text = gizi.nama_gizi,
                                                        style = OutfitTypography.labelLarge
                                                    )
                                                    Text(
                                                        text = "± ${gizi.jumlah} ${gizi.satuan}",
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
                                )
//                                Related Recipe Section
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                        .padding(vertical = 12.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Text(
                                        text = "Resep Masakan Terkait",
                                        style = OutfitTypography.titleLarge
                                    )
                                    LazyRow(
                                        modifier = Modifier
                                            .weight(1f)
                                    ) {
                                        val relatedRecipe = viewModel.relatedRecipes
                                        items(relatedRecipe.take(6)) { recipe ->
                                            val unlocked = userLevel >= recipe.terbuka_di_level
                                            RecipeCard(
                                                foodImg = recipe.imageUrl,
                                                foodName = recipe.judul_konten,
                                                duration = recipe.durasi.toString(),
                                                isUnlocked = unlocked,
                                                requiredLevel = recipe.terbuka_di_level,
                                                onClick = if (unlocked) { {  navController.navigate("recipe_detail/${recipe.id_resep}") } } else null,
                                                modifier = Modifier.weight(1f)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
    }
}