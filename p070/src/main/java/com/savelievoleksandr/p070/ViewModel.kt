package com.savelievoleksandr.p070

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.savelievoleksandr.p070.model.Item
import com.savelievoleksandr.p070.model.ItemData

class ItemViewModel : ViewModel() {
    private val itemData: ItemData = ItemData()
    private val userLiveDataList = MutableLiveData<List<Item>>()
    var userLiveData: LiveData<List<Item>> = userLiveDataList
    fun loadUserData() {
        userLiveDataList.value = itemData.itemList
    }
}