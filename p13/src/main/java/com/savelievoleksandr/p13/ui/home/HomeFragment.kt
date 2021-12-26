package com.savelievoleksandr.p13.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.savelievoleksandr.p13.QuakesAdapter
import com.savelievoleksandr.p13.databinding.FragmentHomeBinding
import com.savelievoleksandr.p13.ui.detailed.DetailedFragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        homeViewModel.quakesLiveData.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = QuakesAdapter(it, this)
            QuakesAdapter(it, this).onItemClick= { quake ->
                Log.d("TAG",quake.geometry.type.toString())
                Toast.makeText(this.context, quake.geometry.type, Toast.LENGTH_SHORT).show()
            }
        })
        homeViewModel.getQuakes()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}