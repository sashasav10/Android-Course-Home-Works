package com.savelievoleksandr.p070

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

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
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewModel.userLiveData.observe(this, Observer {
            for (id in it) {
                if (item.itemId == id.name) {
                    Text.text=id.bio
                    Image.setImageDrawable(
                        getDrawable(resources.getIdentifier(id.photo, null, packageName))
                    )
                }
            }
        }
        )
        return super.onOptionsItemSelected(item)
    }
}