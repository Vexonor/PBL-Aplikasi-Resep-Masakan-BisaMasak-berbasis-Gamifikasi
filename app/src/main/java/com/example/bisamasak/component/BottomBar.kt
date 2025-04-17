package com.example.bisamasak.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Teleport
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

@Composable
fun BottomBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    val navigationBarItems = remember { NavigationBarItems.entries.toTypedArray() }

    AnimatedNavigationBar(
        modifier = Modifier
            .height(120.dp)
            .padding(16.dp),
        selectedIndex = selectedIndex,
        barColor = Color(0xE6ED453A),
        ballColor = Color(0xE6ED453A),
        cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
        ballAnimation = Teleport(tween(300)),
        indentAnimation = Height(tween(300))
    ) {
        navigationBarItems.forEach { item ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable {
                        onItemSelected(item.ordinal)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = item.icons),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = item.label,
                        style = OutfitTypography.labelMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}

enum class NavigationBarItems(@DrawableRes val icons: Int, val label: String) {
    Home(R.drawable.ic_home, "Beranda"),
    Menu(R.drawable.ic_menu, "Menu"),
    Library(R.drawable.ic_book, "Bahan Masak"),
    Profile(R.drawable.ic_user, "Profil")
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}