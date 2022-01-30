package com.savelievoleksandr.p15.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.savelievoleksandr.p15.data.database.TaskDatbase
import com.savelievoleksandr.p15.data.model.TaskDbo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailedTaskViewModel (app: Application) : AndroidViewModel(app) {
    private val _taskDetailedLiveData = MutableLiveData<TaskDbo>()
    val userDetailedLiveData = _taskDetailedLiveData
    val dataSource = TaskDatbase.getInstance(app).taskDatabaseDao()

    fun loadUserDetailedData(index: Int) {
            _taskDetailedLiveData.postValue(dataSource.getTasks(index))
    }

     fun updateUserInfo(taskId: Int,text:String) {
            dataSource.updateTask(taskId,text)
    }
}