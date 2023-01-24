package com.example.kotlin38

import com.example.kotlin38.model.CatModel

interface OnItemTextClickListener {
    fun onClick(model: CatModel)
    fun onLongClick(model: CatModel) : Boolean
}