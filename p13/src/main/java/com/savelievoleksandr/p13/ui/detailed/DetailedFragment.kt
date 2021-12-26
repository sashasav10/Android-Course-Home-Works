package com.savelievoleksandr.p13.ui.detailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.savelievoleksandr.p13.R
import com.savelievoleksandr.p13.model.Feature
import kotlinx.android.synthetic.main.fragment_detailed.*


class DetailedFragment : Fragment() {
    private var param1: Feature? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Feature) =
            DetailedFragment().apply {
//                dtimeTextView.setText(param1.properties.time)
//                dlocationTextView.setText(param1.properties.locality)
//                dquakeValueTextView.setText(param1.properties.magnitude.toString())
            }
    }
}