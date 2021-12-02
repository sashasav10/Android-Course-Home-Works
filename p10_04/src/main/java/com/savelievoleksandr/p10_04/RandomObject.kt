package com.savelievoleksandr.p10_04


import android.content.Context
import kotlin.random.Random

object TransactionsStorage {

    fun random(context: Context) = MutableList(100) {
        Transaction(
            it,
            Random.nextInt(1000, 9999).toString()+" "
                    +Random.nextInt(1000, 9999).toString()+" "
                    +Random.nextInt(1000, 9999).toString()+" "
                    +Random.nextInt(1000, 9999).toString()+" ",
            "1/10/2021",
            Random.nextInt(0, 1000),
            Random.nextInt(1000, 10000)
        )
    }
}
