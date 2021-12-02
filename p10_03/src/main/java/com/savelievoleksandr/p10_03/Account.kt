package com.savelievoleksandr.p10_03

import java.util.*

data class Account (
    val id: Int,
    val name: String,
    var currency: String,
    val cardNumber: String,
    val sum:Int
)