package com.example.bisamasak.data.provider

import com.example.bisamasak.R
import com.example.bisamasak.data.dataContainer.NotificationItem
import com.example.bisamasak.data.dataContainer.RecipeData
import com.example.bisamasak.data.dataContainer.RecipeVertical
import com.example.bisamasak.data.dataContainer.TaskItemData

object DataProvider {
    val ResepRecently = listOf(
        RecipeVertical("file:///android_asset/resep_recently_img/cireng_bumbu_rujak.png", "Cireng Bumbu Rujak","Camilan khas Sunda yang renyah...",10),
        RecipeVertical("file:///android_asset/resep_recently_img/telur_ceplok_pedas.jpg", "Telur Ceplok Pedas",  "Ceplok dengan siraman sambal pedas...",25),
        RecipeVertical("file:///android_asset/resep_recently_img/es_teler.jpg", "Es Teler", "Minuman segar dengan campuran buah...",25),
        RecipeVertical("file:///android_asset/resep_recently_img/ayam_geprek.jpg", "Ayam Geprek", "Ayam goreng crispy yang digeprek dengan...", 30),
        RecipeVertical("file:///android_asset/resep_recently_img/dorayaki.jpg", "Dorayaki", "Pancake ala Jepang berisi kacang...",30),
        RecipeVertical("file:///android_asset/resep_recently_img/es_susu_cincau.jpg", "Es Susu Cincau", "Minuman menyegarkan dengan susu manis...",15),
    )

    val NotifToday = listOf(
        NotificationItem("Masak apa ya hari ini?", "Cobain rekomendasi resep dibawah"),
        NotificationItem("Selamat 30 Poin pertamamu!", "Senang sekali kamu menikmati hari-hari memasakmu bersama BisaMasak!")
    )

    val NotifYesterday = listOf(
        NotificationItem("Masak apa ya hari ini?", "Cobain rekomendasi resep dibawah"),
        NotificationItem("Selamat 30 Poin pertamamu!", "Senang sekali kamu menikmati hari-hari memasakmu bersama BisaMasak!")
    )

    val Notif2Days = listOf(
        NotificationItem("Masak apa ya hari ini?", "Cobain rekomendasi resep dibawah"),
        NotificationItem("Selamat 30 Poin pertamamu!", "Senang sekali kamu menikmati hari-hari memasakmu bersama BisaMasak!")
    )

    val sections = listOf(
        "Hari Ini" to NotifToday,
        "Kemarin" to NotifYesterday,
        "2 hari yang lalu" to NotifYesterday,
        )

    val DailyTask = listOf(
        TaskItemData(R.drawable.ic_coin, "Login hari ini", 200, false),
        TaskItemData(R.drawable.ic_coin, "Baca resep", 300, false),
        TaskItemData(R.drawable.ic_coin, "Unggah resep", 500, false)
    )

}
