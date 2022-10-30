package com.kostyanchikoff.multitypeadaper

import android.view.View

/**
 * Основной интерфейс который передает инфу в/из адаптера
 */
interface Item {

    val layoutId: Int
        get() = -1

    val viewType: Int
        get() = layoutId

    fun bind(holder: BaseMultiTypeViewHolder)

    fun unbind(holder: BaseMultiTypeViewHolder)

    fun createViewHolder(view: View): BaseMultiTypeViewHolder

    fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean

    fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean
}