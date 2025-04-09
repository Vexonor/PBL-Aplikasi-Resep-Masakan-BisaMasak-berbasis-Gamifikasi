package com.example.bisamasak

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.forgot.ForgotScreen
import com.example.bisamasak.kategori_BisaMasak.KategoriBisaMasak
import com.example.bisamasak.kategori_resep_praktis.KategoriResepPraktis
import com.example.bisamasak.kategori_spesial.KategoriSpesialUntukmu
import com.example.bisamasak.kategori_terbaru.KategoriResepTerbaru
import com.example.bisamasak.login.LoginScreen
import com.example.bisamasak.new_password.NewPasswordScreen
import com.example.bisamasak.register.RegisterScreen
import com.example.bisamasak.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "kategori_spesial") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("onBoarding_screen") {
            OnBoardingScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("register_screen") {
            RegisterScreen(navController = navController)
        }
        composable("forgot_screen") {
            ForgotScreen(navController = navController)
        }
        composable("new_password_screen") {
            NewPasswordScreen(navController = navController)
        }
        composable("kategori_resep_praktis") {
            KategoriResepPraktis(navController = navController)
        }
        composable("kategori_BisaMasak") {
            KategoriBisaMasak(navController = navController)
        }
        composable("kategori_terbaru") {
            KategoriResepTerbaru(navController = navController)
        }
        composable("kategori_spesial") {
            KategoriSpesialUntukmu(navController = navController)
        }
    }
}


@Composable
fun SplashScreen (navController: NavController, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_app_logo)
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect (key1 = true) {
        scale.animateTo(
            targetValue = 1.3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("onBoarding_screen") {
            popUpTo("splash_screen") { inclusive = true }
            launchSingleTop = true
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xE6ED453A)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            modifier = Modifier
                .scale(scale.value)
                .size(150.dp),
            contentDescription = null
        )
        Text(
            text = "BisaMasak",
            style = OutfitTypography.displayMedium,
            color = Color.White
        )
    }
}

@Composable
fun OnBoardingScreen (navController: NavController, modifier: Modifier = Modifier) {

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xE6ED453A)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentAlignment = Alignment.Center
            ) {
                Box (
                    modifier = Modifier
                        .size(90.dp)
                        .scale(5f)
                        .background(Color(0xFFFCB912), shape = CircleShape),
                )
                Box (
                    modifier = Modifier
                        .size(100.dp)
                        .scale(4f)
                        .absoluteOffset(x = 10.dp)
                        .border(color = Color(0xE6ED453A), width = 1.dp, shape = CircleShape),
                )
                Column (
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text (
                        text = "BisaMasak",
                        style = OutfitTypography.titleLarge,
                        color = Color.White
                    )
                    Text (
                        text = "Aplikasi Resep Masakan",
                        style = OutfitTypography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }

        Row (
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CardList()
        }

        Row (
            modifier = modifier.height(100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box (
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box (
                    modifier = Modifier
                        .size(100.dp)
                        .scale(5f)
                        .background(Color(0xFFFCB912), shape = CircleShape)
                )
                Box (
                    modifier = Modifier
                        .size(100.dp)
                        .scale(4f)
                        .rotate(180f)
                        .absoluteOffset(x = 8.dp)
                        .border(color = Color(0xE6ED453A), width = 1.dp, shape = CircleShape),
                )
                Column (
                    modifier = modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text (
                        text = "Setelah makan malam yang enak, seseorang bisa memaafkan siapa pun, bahkan kerabatnya sendiri.",
                        style = OutfitTypography.headlineSmall,
                        color = Color.White,
                        modifier = modifier.width(250.dp),
                        textAlign = TextAlign.Center
                    )

                    Button(
                        onClick = {
                            navController.navigate("login_screen") {
                                popUpTo("onBoarding_screen") { inclusive = true } // Hapus OnBoardingScreen dari back stack
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.width(150.dp),
                        shape = CircleShape,
                        colors = ButtonColors(
                            containerColor = Color(0xE6ED453A),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0x80ED453A),
                            disabledContentColor = Color.White
                        ),
                    ) {
                        Text(
                            text = "Mulai",
                            style = OutfitTypography.titleLarge
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Cards(image: Int, rotate: Float, scale: Float, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFE385),
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier
            .size(width = 60.dp, height = 65.dp)
            .rotate(rotate)
            .scale(scale)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(3.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Food List",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(4.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color.White, shape = RoundedCornerShape(2.dp))
            )
        }
    }
}

@Composable
fun CardList () {
    val scaleCard1 = remember {
        Animatable(0f)
    }
    val scaleCard2 = remember {
        Animatable(0f)
    }
    val scaleCard3 = remember {
        Animatable(0f)
    }
    LaunchedEffect (key1 = true) {
        scaleCard2.animateTo(
            targetValue = 3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        scaleCard1.animateTo(
            targetValue = 1.8f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        scaleCard3.animateTo(
            targetValue = 1.5f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(85.dp, Alignment.CenterHorizontally)
    ) {
        Cards(
            image = R.drawable.ic_food_1,
            rotate = -35f,
            scale = scaleCard1.value,
            modifier = Modifier.absoluteOffset(x = -25.dp)
        )
        Cards(
            image = R.drawable.ic_food_2,
            rotate = -15f,
            scale = scaleCard2.value,
        )
        Cards(
            image = R.drawable.ic_food_3,
            rotate = 25f,
            scale = scaleCard3.value,
            modifier = Modifier.absoluteOffset(x = 25.dp)
        )
    }
}

