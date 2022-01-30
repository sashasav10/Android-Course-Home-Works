package com.savelievoleksandr.p15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.savelievoleksandr.p15.ui.AddListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            var dialog= AddListFragment()
            dialog.show(supportFragmentManager,"customDialog")
        }
    }

//    override fun onClick(index: Int) {
//        val intent = Intent(this, DetailedUserActivity::class.java)
//        intent.putExtra("id", index + 1)
//        startActivity(intent)
//    }
}