package com.example.fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.my_fragment.view.*

class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = arguments
        var view = inflater.inflate(R.layout.my_fragment, container, false)
        view.wrtBtn.setOnClickListener {
            view.nameTag.text = bundle?.getString("name") + " " + bundle?.getString("surname")
        }
        return view
    }
}