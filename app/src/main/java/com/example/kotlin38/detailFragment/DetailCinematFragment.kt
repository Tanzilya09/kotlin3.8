package com.example.kotlin38.detailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.kotlin38.R
import com.example.kotlin38.databinding.FragmentDetailCinematBinding
import com.example.kotlin38.model.CatModel


class DetailCinematFragment : Fragment() {
        private lateinit var binding: FragmentDetailCinematBinding
        private var model: CatModel? = null

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding =FragmentDetailCinematBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            click()
            data

        }

        private fun click() {
            binding.closeCinema.setOnClickListener {
                findNavController().navigateUp()
            }
        }

    private val data: Unit
        get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable("key") as CatModel
                binding.imageDetail.let {
                    it.context.let { it1 ->
                        Glide.with(it1).load(model?.name).into(binding.imageDetail)
                    }
                }
                binding.txtNameDetail.text = model?.name
            }
        }
}
