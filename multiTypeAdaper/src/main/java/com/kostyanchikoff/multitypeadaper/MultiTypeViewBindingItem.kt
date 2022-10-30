package com.kostyanchikoff.multitypeadaper

import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * ViewHolder который работает c ViewBinding
 */
class MultiTypeViewBindingViewHolder<T : ViewBinding>(val view: T) : BaseMultiTypeViewHolder(view.root)

/**
 * Реализация item-a для работы с ViewBinding
 */
abstract class MultiTypeViewBindingItem<T : ViewBinding, V : Item> : Item {

    protected abstract fun initializeViewBinding(view: View): T

    override fun createViewHolder(view: View): MultiTypeViewBindingViewHolder<T> {
        val viewBinding = initializeViewBinding(view)
        return MultiTypeViewBindingViewHolder(viewBinding)
    }


    override fun bind(holder: BaseMultiTypeViewHolder) {
        holder.bind(this)
        val newViewHolder = holder as MultiTypeViewBindingViewHolder<T>
        bind(newViewHolder.view)
    }

    override fun unbind(holder: BaseMultiTypeViewHolder) {
        holder.unbind()
    }

    abstract fun bind(viewBinding: T)

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return areContentsTheSameObject(oldItem as? V, newItem as? V)
    }

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return areItemsTheSameObject(oldItem as? V, newItem as? V)
    }

    abstract fun areContentsTheSameObject(oldItem: V?, newItem: V?): Boolean

    abstract fun areItemsTheSameObject(oldItem: V?, newItem: V?): Boolean

}
