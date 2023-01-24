package com.example.kotlin38.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin38.OnItemTextClickListener
import com.example.kotlin38.databinding.ItemTextBinding
import com.example.kotlin38.model.CatModel

class LanguagesAdapter(private val listLanguages: MutableList<CatModel>,
                       private val OnItemTextListener: OnItemTextClickListener
):
    RecyclerView.Adapter<LanguagesAdapter.LanguagesViewHolder>(), View.OnLongClickListener {
    inner class LanguagesViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txt.text = catModel.name
            Glide.with(binding.image.context).load(catModel.cat).into(binding.image)
            itemView.setOnClickListener{
                OnItemTextListener.onClick(catModel)
                binding.txt.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder {
        return LanguagesViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listLanguages[position])
        holder.itemView.setOnLongClickListener{
            listLanguages.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listLanguages.size

    override fun onLongClick(view: View?): Boolean{
        OnItemTextListener.onLongClick(view?.tag as CatModel)
        return true
    }
}