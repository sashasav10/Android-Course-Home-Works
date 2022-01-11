package com.savelievoleksandr.p10_04

import java.util.*

data class Transaction (
    val id: Int,
    val from: String,
    var date: String,
    val sum: Int,
    val balance:Int
)