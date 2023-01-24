package com.example.kotlin38.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin38.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin38.OnItemTextClickListener
import com.example.kotlin38.Repository.CinemaRepositiry
import com.example.kotlin38.adapter.CinemaAdapter
import com.example.kotlin38.databinding.FragmentCinematBinding
import com.example.kotlin38.model.CatModel


class CinematFragment : Fragment(),OnItemTextClickListener {
    private var binding: FragmentCinematBinding? = null
    private val textList = ArrayList<CatModel>()
    private val adapter = CinemaAdapter(textList, this)
    private val repo = CinemaRepositiry()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCinematBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        click()
        initialize()
    }

    private fun click() {
        binding?.btnBackCinema?.setOnClickListener {
            findNavController().navigate(R.id.action_catFragment_to_addCatFragment)
        }
    }
    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(CatModel(textList.toString(),text.toString()))
        }
    }

    private fun initialize() {
        binding?.rvCinemat?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfCinema())
        binding?.rvCinemat?.adapter = adapter
    }

    override fun onClick(textModel: CatModel) {
        val bundle = Bundle()
        bundle.putString("cat", textModel.name)
        findNavController().navigate(R.id.action_cinemaFragment_to_detailCameraFragment)
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}