package com.itechsofsolutions.tictactoe.ui.base.component

import android.view.MotionEvent
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.selection.ItemDetailsLookup

/**
 * This is base view holder class which will be extended for creating next RecyclerView view holders
 * that are selectable
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
abstract class BaseSelectableViewHolder<T>(viewDataBinding: ViewDataBinding) : BaseViewHolder<T>(viewDataBinding) {

    /**
     * This method binds the item to item layout
     *
     * @param item model object
     * @param isActivated if the item is activated
     * */
    fun bind(item: T, isActivated: Boolean) {
        itemView.isActivated = isActivated
        bind(item)
    }

    /**
     * This method returns the details about an item
     * */
    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long? = itemId
                override fun inSelectionHotspot(e: MotionEvent): Boolean {
                    return true
                }
            }
}