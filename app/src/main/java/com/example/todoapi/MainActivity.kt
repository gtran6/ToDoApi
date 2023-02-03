package com.example.todoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapi.adapter.UserAdapter
import com.example.todoapi.databinding.ActivityMainBinding
import com.example.todoapi.viewmodel.MainViewModel
import com.example.todoapi.model.apiResponseItem

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getTodoData()

        mainViewModel.data.observe(this, Observer { list ->
            setAdapter(list)
        })

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun setAdapter(list: List<apiResponseItem>) = binding.recyclerView.apply {
        adapter = UserAdapter(list)
        layoutManager = LinearLayoutManager(this@MainActivity)

    }
}