package com.savelievoleksandr.p15.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.savelievoleksandr.p15.data.model.ToDoListDbo

@Dao
interface ToDoListDao {

    @Query("SELECT * FROM c ORDER BY id DESC")
    fun getCategories(): List<ToDoListDbo>

    @Insert
    fun insert(categoryDbo: ToDoListDbo)

    @Query("UPDATE toDoList SET title = :title WHERE id = :id")
    fun updateTitle(id: Int, title: String)

    @Query("DELETE FROM tasks WHERE categoryId = :categoryId")
    fun delete(categoryId: Int)
    @Query("SELECT * FROM toDoList")
    fun getAllListLiveData(): LiveData<List<ToDoListDbo>>
}