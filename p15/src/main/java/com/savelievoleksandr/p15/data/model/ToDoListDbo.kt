package com.savelievoleksandr.p15.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDoList")
data class ToDoListDbo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val date: String,
)
