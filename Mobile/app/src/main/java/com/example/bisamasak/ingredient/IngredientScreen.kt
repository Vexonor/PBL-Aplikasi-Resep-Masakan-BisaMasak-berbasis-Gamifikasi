package com.example.bisamasak.ingredient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.data.dataContainer.IngredientResponse
import com.example.bisamasak.data.viewModel.IngredientViewModel
import com.example.bisamasak.ingredient.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.launch

class IngredientScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme {
                val navController = rememberNavController()
                IngredientActivity(navController = navController)
            }
        }
    }
}

@Composable
fun IngredientActivity(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        IngredientComponent(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientComponent(navController: NavController) {
//    Bottom Bar
    var selectedIndex by remember { mutableIntStateOf(2) }

//    ViewModel
    val viewModel: IngredientViewModel = viewModel()
    val ingredients = viewModel.ingredientList
    val isLoading = viewModel.isLoading

//    Alphabet Bar
    val listState = rememberLazyListState()
    val grouped = ingredients.filter { it.nama_bahan.isNotEmpty() }
        .groupBy { it.nama_bahan.first().uppercaseChar() }
        .toSortedMap()
    val letterPositions = remember(grouped) {
        val map = mutableMapOf<Char, Int>()
        var index = 1
        grouped.forEach { (char, list) ->
            map[char] = index
            index += 1 + list.size +1
        }
        map
    }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        Log.d("IngredientComponent", "Fetching ingredients...")
        viewModel.ingredient()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Bahan Masak", style = OutfitTypography.titleLarge)
                },
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.Black,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    when (index) {
                        0 -> navController.navigate("home_screen")
                        1 -> navController.navigate("menu_screen")
                        2 -> navController.navigate("ingredient_screen")
                        3 -> navController.navigate("profile_screen?tab=all")
                    }
                }
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 24.dp)
                ) {
                    if (isLoading) {
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 32.dp)
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    } else {
                        item {
                            Header()
                        }
                        grouped.forEach { (initial, items) ->
                            item {
                                Text(
                                    text = initial.toString(),
                                    style = OutfitTypography.titleLarge,
                                    modifier = Modifier
                                        .padding(top = 16.dp, bottom = 8.dp)
                                )
                            }
                            items(items) { ingredient ->
                                IngredientItem(ingredient = ingredient) { id ->
                                    navController.navigate("ingredient_detail/$id")
                                }
                            }
                            item {
                                HorizontalDivider(
                                    modifier = Modifier
                                        .padding(top = 16.dp, bottom = 16.dp)
                                        .fillMaxWidth(),
                                    thickness = 1.dp,
                                    color = Color(0xFF748189)
                                )
                            }
                        }
                    }
                }

                AlphabetBar(
                    grouped = grouped,
                    letterPositions = letterPositions,
                    toHeader = { index ->
                        coroutineScope.launch {
                            try {
                                val maxIndex = listState.layoutInfo.totalItemsCount
                                val safeIndex = index.coerceIn(0, maxIndex - 1)
                                listState.animateScrollToItem(safeIndex)
                            } catch (e: Exception) {
                                Log.e("IngredientComponent", "Failed to scroll: ${e.message}")
                            }
                        }
                    },
                    modifier = Modifier
                        .width(32.dp)
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Composable
fun IngredientItem(ingredient: IngredientResponse, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { onClick(ingredient.id_bahan) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ingredient.gambar_bahan,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(52.dp)
                .padding(end = 16.dp)
        )
        Text(
            text = ingredient.nama_bahan.replaceFirstChar { it.uppercase() },
            style = OutfitTypography.titleMedium
        )
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Ini perpustakaan bahan masak kami",
            style = OutfitTypography.titleMedium,
            color = Color(0xFF748189)
        )
        Text(
            text = "Spesial untukmu!",
            style = OutfitTypography.titleLarge,
            color = Color(0xFF748189)
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
                .fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0xFF748189)
        )
    }
}

@Composable
fun AlphabetBar(
    grouped: Map<Char, List<IngredientResponse>>,
    letterPositions: Map<Char, Int>,
    toHeader: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        for (alphabet in 'A'..'Z') {
            val isAvailable = grouped.containsKey(alphabet)

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(enabled = isAvailable) {
                        letterPositions[alphabet]?.let { toHeader(it) }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = alphabet.toString(),
                    color = if (isAvailable) Color.Black else Color.LightGray,
                    style = OutfitTypography.labelMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}