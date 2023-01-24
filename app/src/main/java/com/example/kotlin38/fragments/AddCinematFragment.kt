package com.example.kotlin38.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin38.R
import com.example.kotlin38.databinding.FragmentAddCinematBinding


class AddCinematFragment : Fragment() {


    private var binding: FragmentAddCinematBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCinematBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        binding?.btnCinema?.setOnClickListener {
            val bundle1 = Bundle()
            bundle1.putString("cat2", binding?.edCinema?.text.toString())
            findNavController().navigate(R.id.action_addCinemaFragment_to_cinemaFragment, bundle1)
        }
    }
}