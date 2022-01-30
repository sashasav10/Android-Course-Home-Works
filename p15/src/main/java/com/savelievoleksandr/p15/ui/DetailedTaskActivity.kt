package com.savelievoleksandr.p15.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.savelievoleksandr.p15.databinding.TasksDetailedBinding
import com.savelievoleksandr.p15.ui.viewModel.DetailedTaskViewModel
import kotlin.properties.Delegates

class DetailedTaskActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailedTaskViewModel
    private lateinit var binding: TasksDetailedBinding
    private var index by Delegates.notNull<Int>()


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TasksDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(DetailedTaskViewModel::class.java)

        val taskName: TextView = binding.titleTextView
        //  private val isChecked : CheckBox = binding.taskCheckBox


        val arguments = intent.extras
        index = arguments?.getInt("id")!!.toInt()
        viewModel.loadUserDetailedData(index)

    }
}