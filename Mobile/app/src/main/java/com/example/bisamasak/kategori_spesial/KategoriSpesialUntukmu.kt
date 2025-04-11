package com.example.bisamasak.kategori_spesial


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.dataresep.DataProvider
import com.example.bisamasak.R
import com.example.bisamasak.kategori_terbaru.KategoriResepTerbaru
import com.example.bisamasak.ui.theme.OutfitFont


@Composable
fun KategoriSpesialUntukmu(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFED453A),
                    modifier = Modifier
                        .size(24.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Spesial Untukmu",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = OutfitFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(19.dp), //
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 10.dp,
                    bottom = 80.dp //
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                items(DataProvider.ResepSpesial) { recipe ->
                    Box(
                        modifier = Modifier
                            .width(162.dp)
                            .height(201.dp)
                            .shadow(
                                elevation = 2.dp,
                                shape = MaterialTheme.shapes.medium,
                                spotColor = Color.Black
                            )
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Image(
                                painter = painterResource(id = recipe.image),
                                contentDescription = recipe.name,
                                modifier = Modifier
                                    .size(width = 143.dp, height = 111.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = recipe.name,
                                fontFamily = OutfitFont,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_timer_24),
                                contentDescription = "Durasi",
                                tint = Color.Black.copy(alpha = 0.5f),
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                text = "${recipe.duration} mnt",
                                fontFamily = OutfitFont,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black.copy(alpha = 0.5f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKategoriSpesialUntukmu() {
    val navController = rememberNavController()
    KategoriSpesialUntukmu(navController)
}








