package com.savelievoleksandr.p10_01


import android.content.Context
import kotlin.random.Random

object PhotosStorage {

    fun random(context: Context) = MutableList(100) {
        Photos(
            it,
            "https://picsum.photos/200",
            Random.nextInt(0,1000),
            "That's a good photo")
    }
}

