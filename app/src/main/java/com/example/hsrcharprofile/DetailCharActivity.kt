package com.example.hsrcharprofile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailCharActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)

        supportActionBar?.apply {
            title = getString(R.string.detail_char)
        }

        val detailChar = intent.getParcelableExtra<Character>(MainActivity.INTENT_SEND)

        val photo = findViewById<ImageView>(R.id.photo_img)
        val name = findViewById<TextView>(R.id.char_name)
        val charRarity = findViewById<TextView>(R.id.rarity_char)
        val charPath = findViewById<TextView>(R.id.path_char)
        val faction = findViewById<TextView>(R.id.faction_char)
        val detail = findViewById<TextView>(R.id.description)

        photo.setImageResource(detailChar?.photo!!)
        name.text = detailChar.name
        charRarity.text = detailChar.rarity
        charPath.text = detailChar.path
        faction.text = detailChar.faction
        detail.text = detailChar.detail

    }
}