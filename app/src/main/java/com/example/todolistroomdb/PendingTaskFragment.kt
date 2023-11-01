package com.example.todolistroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolistroomdb.databinding.FragmentPendingTaskBinding

class PendingTaskFragment : Fragment() {

    lateinit var binding: FragmentPendingTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPendingTaskBinding.inflate(inflater, container ,false)




        return binding.root
    }
}