package com.evgeniypavlovich.citiesofkrasnodarregion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)
        val link = Uri.parse("https://ru.wikipedia.org/wiki/Краснодарский_край")
        val intent = Intent(Intent.ACTION_VIEW, link)

        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.to_learn_more -> {
                    startActivity(intent)
                }
                R.id.about -> {
                    val aboutFragment = AboutFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, aboutFragment)
                        .commit()
                }
                R.id.description -> {
                    val infoFragment = InfoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, infoFragment)
                        .commit()
                }
            }
            true
        }
        bottomMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.description

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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}




