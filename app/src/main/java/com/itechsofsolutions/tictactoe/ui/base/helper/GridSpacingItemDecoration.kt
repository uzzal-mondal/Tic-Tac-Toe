package com.itechsofsolutions.tictactoe.ui.base.helper

import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.RecyclerView

/**
 * This is a class that creates space decoration for GridLayoutManager of RecyclerView
 * @author Mohd. Asfaq-E-Azam Rifat
 *
 * @see "If this item decoration is added to any [RecyclerView], then we need to remove it at
 * onStop() of the fragment/activity. Otherwise, the margin gets incremented each time."
 * */
class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int,
                                private val willIncludeEdge: Boolean) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column

        if (willIncludeEdge) {
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) { // top edge
                outRect.top = spacing
            }
            outRect.bottom = spacing // item bottom
        } else {
            outRect.left = column * spacing / spanCount
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}