package com.evgeniypavlovich.citiesofkrasnodarregion

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(banner: Banner) {
        val bannerImageView: ImageView = itemView.findViewById(R.id.banner_image_view)
        val bannerDescriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        val bannerPopulation: Int = banner.population


        bannerImageView.setImageDrawable(itemView.context.getDrawable(banner.imageRes))
        bannerDescriptionTextView.text = banner.description


        itemView.setOnClickListener {
           val toast = Toast.makeText(
                itemView.context,
                bannerDescriptionTextView.text as String + " population " +
                        bannerPopulation + " people", Toast.LENGTH_SHORT)
            val location :IntArray=IntArray(2)
            itemView.getLocationOnScreen(location)
            toast.setGravity(Gravity.TOP,0,location[1])
            toast.show()

        }
    }
}