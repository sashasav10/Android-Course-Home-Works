package com.savelievoleksandr.p10_01

data class Photos (
    val id: Int,
    val photo: String,
    var likes: Int,
    val description: String
)