package com.savelievoleksandr.p070

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        var animals = findViewById<RadioButton>(R.id.animalRdBtn)
        var plants = findViewById<RadioButton>(R.id.plantRdBtn)
        if (animals.isChecked) {
            menu?.setGroupVisible(R.id.group_animal, true)
            menu?.setGroupVisible(R.id.group_plant, false)
        }
        if (plants.isChecked) {
            menu?.setGroupVisible(R.id.group_animal, false)
            menu?.setGroupVisible(R.id.group_plant, true)
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var Text = findViewById<TextView>(R.id.DescriptionTextView)
        var Image = findViewById<ImageView>(R.id.IconImageView)
        Image
        when (item.itemId) {
            R.id.menu_crocodile -> {
                Text.text = "Крокодил"
                Image.setImageResource(R.drawable.crodile)
            }
        }
        when (item.itemId) {
            R.id.menu_lizard -> {
                Text.text = "Ящерица"
                Image.setImageResource(R.drawable.lizard)
            }
        }
        when (item.itemId) {
            R.id.menu_vorona -> {
                Text.text = "Ворона"
                Image.setImageResource(R.drawable.vorona)
            }
        }
        when (item.itemId) {
            R.id.menu_aist -> {
                Text.text = "Аист"
                Image.setImageResource(R.drawable.aist)
            }
        }
        when (item.itemId) {
            R.id.menu_dub -> {
                Text.text = "Дуб"
                Image.setImageResource(R.drawable.oak)
            }
        }
        when (item.itemId) {
            R.id.menu_sosna -> {
                Text.text = "Сосна"
                Image.setImageResource(R.drawable.sosna)
            }
        }
        when (item.itemId) {
            R.id.menu_malina -> {
                Text.text = "Малина"
                Image.setImageResource(R.drawable.malina)
            }
        }
        when (item.itemId) {
            R.id.menu_nevesta -> {
                Text.text = "Невеста"
                Image.setImageResource(R.drawable.nevesta)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}