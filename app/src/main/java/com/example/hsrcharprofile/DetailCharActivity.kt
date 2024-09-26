package com.example.hsrcharprofile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DetailCharActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)

        supportActionBar?.apply {
            title = getString(R.string.detail_char)
        }

        val detailChar = intent.getParcelableExtra<Character>(MainActivity.INTENT_SEND)

        if (detailChar == null) {
            Toast.makeText(this, "Character data is unavailable", Toast.LENGTH_SHORT).show()
            return
        }

        with(detailChar) {
            findViewById<ImageView>(R.id.photo_img).setImageResource(photo)
            findViewById<TextView>(R.id.char_name).text = name
            findViewById<TextView>(R.id.rarity_char).text = rarity
            findViewById<TextView>(R.id.path_char).text = path
            findViewById<TextView>(R.id.faction_char).text = faction
            findViewById<TextView>(R.id.description).text = detail
        }

    }
}