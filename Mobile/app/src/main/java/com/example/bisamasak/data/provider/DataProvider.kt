package com.example.bisamasak.data.provider

import com.example.bisamasak.R
import com.example.bisamasak.data.dataContainer.RecipeData

object DataProvider {
    val ResepPraktis = listOf(
        RecipeData(R.drawable.perkedel, "Perkedel Jagung Tempe", 20),
        RecipeData(R.drawable.susukurma, "Susu Kurma Madu", 10),
        RecipeData(R.drawable.seblak, "Seblak Ceker dengan Kerupuk", 30),
        RecipeData(R.drawable.bayam, "Tumis Bayam Saus Tiram", 15),
        RecipeData(R.drawable.sarden, "Sarden Asam Manis", 30),
        RecipeData(R.drawable.sup, "Sup Bakso Wortel", 15),
        RecipeData(R.drawable.dorayaki, "Dorayaki", 30),
        RecipeData(R.drawable.cincau, "Es Susu Cincau", 15),
    )

    val ResepBisaMasak = listOf(
        RecipeData(R.drawable.geprek, "Ayam Geprek", 30),
        RecipeData(R.drawable.teler, "Es Teler", 25),
        RecipeData(R.drawable.nasgor, "Nasi Goreng Jagung", 20),
        RecipeData(R.drawable.ubi, "Kue Lumpur Ubi", 40),
        RecipeData(R.drawable.klepon, "Klepon", 20),
        RecipeData(R.drawable.bakwan, "Bakwan Jagung", 15),
        RecipeData(R.drawable.martabak, "Martabak Nasi", 45),
        RecipeData(R.drawable.spring, "Spring Roll", 35),
    )

    val ResepTerbaru = listOf(
        RecipeData(R.drawable.gulai, "Gulai Udang Kacang Panjang", 60),
        RecipeData(R.drawable.siomay, "Siomay Ikan Rumahan", 45),
        RecipeData(R.drawable.jambal, "Nasi Goreng Jambal Bumbu Merah", 15),
        RecipeData(R.drawable.udang, "Tumis Rebung Udang", 10),
        RecipeData(R.drawable.ceplok, "Telur Ceplok Pedas", 25),
        RecipeData(R.drawable.kwetiau, "Kwetiaw Goreng", 15),
        RecipeData(R.drawable.ayam, "Ayam Goreng Terasi", 45),
        RecipeData(R.drawable.jelly, "Es Jelly Yakult", 20),
    )

    val ResepSpesial = listOf(
        RecipeData(R.drawable.udang_mayo, "Udang Mayonaise", 50),
        RecipeData(R.drawable.buntut, "Sop Buntut", 60),
        RecipeData(R.drawable.doffle, "Doffle (Donat Waffle)", 35),
        RecipeData(R.drawable.pudding, "Mango Pudding", 30),
        RecipeData(R.drawable.roti, "Roti Bakar Coklat Keju", 35),
        RecipeData(R.drawable.mentai, "Siomay Ayam Mentai", 45),
        RecipeData(R.drawable.kenyal, "Donat Kenyal", 45),
        RecipeData(R.drawable.pancake, "Pancake Avocado", 40),
    )
}