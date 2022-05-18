package com.example.listadaptertest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadaptertest2.data.MainData
import com.example.listadaptertest2.databinding.ActivityMainBinding
import com.example.listadaptertest2.databinding.ItemMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivityAdapter:  ListAdapter<MainData, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            val mainData = getItem(position) as MainData
            holder.bind(mainData)
        }
    }



class MyViewHolder (private val binding: ItemMainBinding ) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MainData) {
        with(binding) {
            tvName.text = "Name: ${data.name}"
            tvStats.text = "HP: ${data.stats[0]} / MP: ${data.stats[1]} / EXP: ${data.stats[2]}"

            layoutMainItem.setOnClickListener {
                Snackbar.make(it, "Item $layoutPosition touched!", Snackbar.LENGTH_SHORT).show()
            }

            tvName.setOnClickListener {
                Snackbar.make(it, "Item $layoutPosition touched name!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

}

    class MyDiffCallback : DiffUtil.ItemCallback<MainData>() {
        override fun areItemsTheSame(oldItem: MainData, newItem: MainData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MainData, newItem: MainData): Boolean {
            return oldItem == newItem
        }
    }

}
