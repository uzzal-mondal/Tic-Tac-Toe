package com.itechsofsolutions.tictactoe.ui.base.component

import androidx.recyclerview.selection.SelectionTracker
import com.itechsofsolutions.tictactoe.ui.base.callback.SelectionListener

/**
 * This is base adapter class which will be extended for creating
 * next RecyclerView selectable adapters
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
abstract class BaseSelectableAdapter<T> : BaseAdapter<T>() {
    var tracker: SelectionTracker<Long>? = null
    var selectionListener: SelectionListener? = null

    init {
        setHasStableIds(true)
    }

    abstract fun getItemIdForPosition(position: Int): Long

    override fun getItemId(position: Int): Long {
        return getItemIdForPosition(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = getItem(position)

        if (item != null) {
            tracker?.let {
                (holder as BaseSelectableViewHolder)
                        .bind(item, it.isSelected(getItemIdForPosition(position)))
                selectionListener?.onSelect(tracker?.selection?.size()!!)
            }
        }
    }
}