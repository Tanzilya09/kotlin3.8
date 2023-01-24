package com.example.kotlin38.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin38.R
import com.example.kotlin38.databinding.FragmentAddCatBinding


class AddCatFragment : Fragment() {

    private var binding: FragmentAddCatBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        binding?.btCat?.setOnClickListener {
            val bundle1 = Bundle()
            bundle1.putString("cat2", binding?.edCat?.text.toString())
            findNavController().navigate(R.id.action_AddCatFragment_to_catFragment, bundle1)
        }
    }
}