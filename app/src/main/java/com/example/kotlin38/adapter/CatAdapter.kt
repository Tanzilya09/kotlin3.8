package com.example.kotlin38.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin38.OnItemTextClickListener
import com.example.kotlin38.databinding.ItemTextBinding
import com.example.kotlin38.model.CatModel

class CatAdapter(private val listCat: MutableList<CatModel>,
                 private val onItemTextListener : OnItemTextClickListener
): RecyclerView.Adapter<CatAdapter.CatViewHolder>(), OnLongClickListener{

    inner class CatViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txt.text = catModel.name
            Glide.with(binding.image.context).load(catModel.cat).into(binding.image)
            itemView.setOnClickListener{
                onItemTextListener.onClick(catModel)
                binding.txt.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener{
            listCat.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listCat.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener.onLongClick(v?.tag as CatModel)
        return true
    }


}