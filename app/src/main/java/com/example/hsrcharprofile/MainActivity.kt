package com.example.hsrcharprofile

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    companion object {
        val INTENT_SEND = "OBJECT_SENT"
    }

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
        val datararity = resources.getStringArray(R.array.data_rarity)
        val dataPathChar = resources.getStringArray(R.array.data_path)
        val dataFaction = resources.getStringArray(R.array.data_faction)
        val dataDetail = resources.getStringArray(R.array.data_detail_char)
        val listChar = ArrayList<Character>()

        for (i in dataName.indices){
            val char = Character(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), datararity[i],dataPathChar[i], dataFaction[i], dataDetail[i])
            listChar.add(char)
        }
        return listChar
    }

    private fun showRecyclerList(){
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter

        listCharAdapter.setOnItemClickCallback(object : ListCharAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Character) {
                val intoToDetail = Intent(this@MainActivity, DetailCharActivity::class.java)
                intoToDetail.putExtra(INTENT_SEND, data)
                startActivity(intoToDetail)
            }
        })
    }

    // Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

}