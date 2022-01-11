package com.savelievoleksandr.p10_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = OrdersAdapter(OrdersStorage.random(this))
    }
}