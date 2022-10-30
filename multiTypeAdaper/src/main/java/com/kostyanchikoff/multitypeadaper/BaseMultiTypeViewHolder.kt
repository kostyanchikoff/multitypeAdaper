package com.kostyanchikoff.multitypeadaper

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Базовый ViewHolder
 */
open class BaseMultiTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var _itemConfig: Item? = null
    val group: Item?
        get() = _itemConfig

    fun bind(group: Item) {
        this._itemConfig = group
    }

    fun unbind() {
        this._itemConfig = null
    }

}

