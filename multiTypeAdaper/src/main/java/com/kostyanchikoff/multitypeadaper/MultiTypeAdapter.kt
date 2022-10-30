package com.kostyanchikoff.multitypeadaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Адаптер который работает с различными типами с возможностью не указывать тип через ViewType
 * Все происходит автоматом
 */
class MultiTypeAdapter : ListAdapter<Item, BaseMultiTypeViewHolder>(

    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.areContentsTheSame(oldItem, newItem)
        }

    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMultiTypeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item: Item = getViewTypeByPosition(viewType)
        val itemView: View = inflater.inflate(item.layoutId, parent, false)
        return item.createViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseMultiTypeViewHolder, position: Int) {
        val group = getItem(position)
        group.bind(holder)
    }

    override fun onViewRecycled(holder: BaseMultiTypeViewHolder) {
        val contentItem = holder.group
        contentItem?.unbind(holder)
    }

    private fun getViewTypeByPosition(viewType: Int): Item {
        return currentList.find { it.viewType == viewType } ?: throw Throwable("check view type")
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }
}