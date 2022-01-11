package com.savelievoleksandr.p10_02

data class Orders (
    val id: Int,
    val name: String,
    var address: String,
    val content: String,
    val sum:Int
)