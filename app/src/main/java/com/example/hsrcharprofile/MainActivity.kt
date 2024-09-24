package com.example.hsrcharprofile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var rvChar: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChar = findViewById(R.id.rv_char)
        rvChar.setHasFixedSize(true)


        list.addAll(getListChar())
        showRecyclerList()
    }

    private fun getListChar(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_char)
        val dataDescription = resources.getStringArray(R.array.data_char_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listChar = ArrayList<Character>()

        for (i in dataName.indices){
            val char = Character(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listChar.add(char)
        }
        return listChar
    }

    private fun showRecyclerList(){
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter
    }
}