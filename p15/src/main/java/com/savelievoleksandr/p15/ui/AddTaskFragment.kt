package com.savelievoleksandr.p15.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.savelievoleksandr.p15.R
import com.savelievoleksandr.p15.data.model.ToDoListDbo

class AddTaskFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstantState: Bundle?,
    ): View? {
        var rootview: View = inflater.inflate(R.layout.fragment_add_list, container, false)
        var addButton = rootview.findViewById<Button>(R.id.addButton)
        var cancelButton = rootview.findViewById<Button>(R.id.cancelButton)
        var taskName = rootview.findViewById<Button>(R.id.taskNameEditText)
        cancelButton.setOnClickListener {
            dismiss()
        }
        addButton.setOnClickListener {
            // val task= ToDoList(0,taskName.text.toString(),"0",)
        }
        return rootview
    }
}