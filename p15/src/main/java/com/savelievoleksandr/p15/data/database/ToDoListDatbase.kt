package com.savelievoleksandr.p15.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.savelievoleksandr.p15.data.model.ToDoListDbo

@Database(entities = [ToDoListDbo::class], version = 1, exportSchema = false)
abstract class ToDoListDatbase : RoomDatabase() {

    abstract fun listDatabaseDao(): ToDoListDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoListDatbase? = null

        fun getInstance(context: Context): ToDoListDatbase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoListDatbase::class.java,
                        "toDoList"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}