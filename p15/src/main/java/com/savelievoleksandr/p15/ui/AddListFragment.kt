package com.savelievoleksandr.p15.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.savelievoleksandr.p15.R
import com.savelievoleksandr.p15.data.model.ToDoListDbo
import com.savelievoleksandr.p15.ui.viewModel.AddListFragmentViewModel
import com.savelievoleksandr.p15.ui.viewModel.ListViewModel

class AddListFragment:DialogFragment() {
    private lateinit var viewModel: AddListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstantState: Bundle?,
    ): View? {
        viewModel = ViewModelProvider(this).get(AddListFragmentViewModel::class.java)

        var rootview:View=inflater.inflate(R.layout.fragment_add_list, container, false)
        var addButton=rootview.findViewById<Button>(R.id.addButton)
        var cancelButton=rootview.findViewById<Button>(R.id.cancelButton)
        var taskName=rootview.findViewById<Button>(R.id.taskNameEditText)
        cancelButton.setOnClickListener{
            dismiss()
        }
        addButton.setOnClickListener{
            val task= ToDoListDbo(0,taskName.text.toString(),"0",)
            viewModel.insertList(task)
        }
        return rootview
    }
}