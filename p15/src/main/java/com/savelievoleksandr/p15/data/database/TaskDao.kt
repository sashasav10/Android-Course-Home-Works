package com.savelievoleksandr.p15.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.savelievoleksandr.p15.data.model.TaskDbo
import com.savelievoleksandr.p15.data.model.ToDoListDbo

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks WHERE categoryId = :categoryId ORDER BY id DESC")
    fun getTasks(categoryId: Int): MutableLiveData<TaskDbo>

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId")
    fun getTasksCount(categoryId: Int): Int

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId AND isChecked = 1")
    fun getFinishedTasksCount(categoryId: Int): Int

    @Insert
    fun insert(taskDbo: TaskDbo)

    @Query("UPDATE tasks SET name = :text WHERE id = :id")
    fun updateTask(id: Int, text: String)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    fun delete(taskId: Int)

    @Query("DELETE FROM tasks WHERE categoryId = :categoryId")
    fun deleteByCategory(categoryId: Int)
    @Query("SELECT * FROM toDoList")
    fun getAlltaskLiveData(): LiveData<List<ToDoListDbo>>
}
