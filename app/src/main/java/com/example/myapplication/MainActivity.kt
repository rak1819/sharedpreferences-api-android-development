package com.example.myapplication

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nametext:EditText
    private lateinit var agetext:EditText
    private lateinit var sf :SharedPreferences
    private lateinit var editor: Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nametext = findViewById(R.id.name)
        agetext = findViewById(R.id.age)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val nametemp = nametext.text.toString()
        val agetemp = agetext.text.toString().toInt()
        editor.apply {
            putString("sf_name",nametemp)
            putInt("sf_age",agetemp)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val nameget = sf.getString("sf_name",null)
        val ageget = sf.getInt("sf_age",0)
        nametext.setText(nameget)
        if(ageget!=0){
            agetext.setText(ageget.toString())
        }

    }

}