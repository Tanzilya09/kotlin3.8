package com.example.kotlin38.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin38.OnItemTextClickListener
import com.example.kotlin38.R
import com.example.kotlin38.Repository.CatRepositiry
import com.example.kotlin38.adapter.CatAdapter
import com.example.kotlin38.databinding.FragmentCatBinding
import com.example.kotlin38.model.CatModel


class CatFragment : Fragment(), OnItemTextClickListener {
    private var binding: FragmentCatBinding? = null
    private val textList = ArrayList<CatModel>()
    private val adapter = CatAdapter(textList, this)
    private val repo = CatRepositiry()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        click()
        initialize()
    }

    private fun click() {
        binding?.btnToThirdFragCat?.setOnClickListener {
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
        binding?.rvCat?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfText())
        binding?.rvCat?.adapter = adapter
    }

    override fun onClick(textModel: CatModel) {
        val bundle = Bundle()
        bundle.putString("cat", textModel.name)
        findNavController().navigate(R.id.action_catFragment_to_detailCatFragment)
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}