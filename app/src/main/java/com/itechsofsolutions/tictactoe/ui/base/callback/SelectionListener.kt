package com.itechsofsolutions.tictactoe.ui.base.callback

/**
 * This is a interface that contains callback methods to work with RecyclerView item selection
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
interface SelectionListener {
    /**
     * This method is called when an item gets selected/deselected.
     *
     * @param size size of selection
     */
    fun onSelect(size: Int)
}