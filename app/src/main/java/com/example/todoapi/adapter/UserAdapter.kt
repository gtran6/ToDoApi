package com.example.todoapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapi.databinding.ItemTodoBinding
import com.example.todoapi.model.apiResponseItem

class UserAdapter(val list: List<apiResponseItem>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    class ListViewHolder (var binding: ItemTodoBinding) :
        RecyclerView.ViewHolder (binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.userId.text = list[position].id.toString()
        holder.binding.userTitle.text = list[position].title
        holder.binding.userStatus.text = list[position].completed.toString()
    }
}