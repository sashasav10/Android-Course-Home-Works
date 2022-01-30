package com.savelievoleksandr.p15.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.savelievoleksandr.p15.data.database.ToDoListDatbase
import com.savelievoleksandr.p15.data.model.ToDoListDbo

class AddListFragmentViewModel(application: Application) : AndroidViewModel(application)  {
    val dataSource = ToDoListDatbase.getInstance(application).ToDoListDao()
    var size = 0
//    init {
//            size = dataSource.size()
//
//    }

    fun insertList(task: ToDoListDbo) {
            dataSource.insert(task)
    }
}