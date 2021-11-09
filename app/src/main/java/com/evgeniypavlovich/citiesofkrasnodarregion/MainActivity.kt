package com.evgeniypavlovich.citiesofkrasnodarregion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bannerList: List<Banner> = listOf(
            Banner(R.drawable.banner_images_krasnodar, "Krasnodar", 948827),
            Banner(R.drawable.banner_images_sochi, "Sochi", 432322),
            Banner(R.drawable.banner_images_novorossiysk, "Novorossiysk", 275795),
            Banner(R.drawable.banner_images_armavir, "Armavir", 187215),
            Banner(R.drawable.banner_images_anapa, "Anapa", 94340),
            Banner(R.drawable.banner_images_yeysk, "Yeysk", 83127),
            Banner(R.drawable.banner_images_kropotkin, "Kropotkin", 77074),
            Banner(R.drawable.banner_images_gelendzhik, "Gelendzhik", 75504),
            Banner(R.drawable.banner_images_slavyansk_on_kuban, "Slavyansk-on-Kuban", 67777),
            Banner(R.drawable.banner_images_tuapse, "Tuapse", 60987)
        )
        val usersRecyclerView: RecyclerView = findViewById(R.id.users_recycler_view)
        usersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                usersRecyclerView.adapter = BannerAdapter(bannerList)
    }
}




