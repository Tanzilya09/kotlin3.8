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
import com.example.kotlin38.Repository.LanguagesRepository
import com.example.kotlin38.adapter.LanguagesAdapter
import com.example.kotlin38.databinding.FragmentProgrammingLanguagesBinding
import com.example.kotlin38.model.CatModel


class ProgrammingLanguagesFragment : Fragment() ,OnItemTextClickListener {
    private var binding: FragmentProgrammingLanguagesBinding? = null
    private val textList = ArrayList<CatModel>()
    private val adapter = LanguagesAdapter(textList, this)
    private val repository = LanguagesRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgrammingLanguagesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
        getData()
        initialize()
    }

    private fun click() {
        binding?.btnToThirdFragLang?.setOnClickListener {
            findNavController().navigate(R.id.action_programming_languages_fragment_to_edLanguagesFragment)
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
        binding?.rvLanguage?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repository.getListOfText())
        binding?.rvLanguage?.adapter = adapter
    }


    override fun onClick(textModel: CatModel) {
        val bundle = Bundle()
        bundle.putString("cat", textModel.name)
        findNavController().navigate(R.id.action_programming_languages_fragment_to_detailLanguagesFragment)
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}