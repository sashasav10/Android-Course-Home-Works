package com.savelievoleksandr.p15.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.savelievoleksandr.p15.data.model.ToDoListDbo

@Database(entities = [ToDoListDbo::class], version = 1, exportSchema = false)
abstract class TaskDatbase : RoomDatabase() {

    abstract fun taskDatabaseDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatbase? = null

        fun getInstance(context: Context): TaskDatbase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatbase::class.java,
                        "tasks"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}