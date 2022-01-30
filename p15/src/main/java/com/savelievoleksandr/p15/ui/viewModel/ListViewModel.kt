package com.savelievoleksandr.p15.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.savelievoleksandr.p15.data.database.ToDoListDatbase
import com.savelievoleksandr.p15.data.model.ToDoListDbo

class ListViewModel(app: Application) : AndroidViewModel(app) {
    val listLiveDataList = MutableLiveData<List<ToDoListDbo>>()
    var userLiveData: LiveData<List<ToDoListDbo>> = listLiveDataList
    var dataSource = ToDoListDatbase.getInstance(app).listDatabaseDao()
    private var id = MutableLiveData<Int>()
    val userId: LiveData<Int> = id

    init {
        fillUpDatabase()
        loadToDoListDboData()
    }

    fun fillUpDatabase() {
        for (task in dataSource.getCategories()) {
            dataSource.insert(task)
        }
    }

    fun loadToDoListDboData() {
        listLiveDataList.postValue(dataSource.getCategories())
    }

    fun getAllLivaData(): LiveData<List<ToDoListDbo>> {
        return dataSource.getAllListLiveData()
    }
}