package com.kostyanchikoff.adapter

import android.view.View
import com.kostyanchikoff.adapter.databinding.ItemTestBinding
import com.kostyanchikoff.multitypeadaper.MultiTypeViewBindingItem


class TestItem(private val text: String) : MultiTypeViewBindingItem<ItemTestBinding, TestItem>() {

    override fun initializeViewBinding(view: View) = ItemTestBinding.bind(view)

    override val layoutId: Int
        get() = R.layout.item_test

    override fun bind(viewBinding: ItemTestBinding) {
        viewBinding.helloWorld.text = text
    }

    override fun areContentsTheSameObject(oldItem: TestItem?, newItem: TestItem?): Boolean {
        return oldItem?.text == newItem?.text
    }

    override fun areItemsTheSameObject(oldItem: TestItem?, newItem: TestItem?): Boolean {
        return oldItem?.text == newItem?.text
    }


}