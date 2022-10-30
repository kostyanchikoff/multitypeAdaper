package com.kostyanchikoff.adapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.kostyanchikoff.adapter.databinding.ActivityMainBinding
import com.kostyanchikoff.adapter.databinding.ItemTest2Binding
import com.kostyanchikoff.multitypeadaper.MultiTypeAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = MultiTypeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf(TestItem("hello"), TestItem("hello"), TestItem("hello adapter"))
        val list2 = listOf(TestItem("hello"), TestItem("hello"), TestItem("hello adapter"))

        binding.recyclerView.adapter = adapter
        adapter.submitList(list)

        binding.button.setOnClickListener {
            adapter.submitList(list2)
        }
    }
}


