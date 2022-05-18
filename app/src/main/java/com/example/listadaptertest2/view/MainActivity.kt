package com.example.listadaptertest2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadaptertest2.adapter.MainActivityAdapter
import com.example.listadaptertest2.data.MainData
import com.example.listadaptertest2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val dataSet = arrayListOf<MainData>().apply {
        add(MainData("타일런트",   listOf(100, 10, 50)))
        add(MainData("조커",  listOf(200, 20, 100)))
        add(MainData("그렘린",  listOf(10, 1, 5)))
        add(MainData("리오레우스", listOf(10000, 1000, 50000)))
        add(MainData("사우론", listOf(1000, 200, 1000)))
        add(MainData("리바이어던", listOf(2000, 250, 10000)))
    }

    private val myRecyclerViewAdapter: MainActivityAdapter by lazy {
        MainActivityAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = myRecyclerViewAdapter
        }
        myRecyclerViewAdapter.submitList(dataSet)

    }
}