package com.itechsofsolutions.tictactoe.ui.base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.CalendarView

/**
 * This is a custom CalendarView which works well if putted inside a scrollview.
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class ScrollableCalendarView : CalendarView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet,
                defStyle: Int) : super(context, attrs, defStyle)

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked == MotionEvent.ACTION_DOWN) {
            val parent = parent
            parent?.requestDisallowInterceptTouchEvent(true)
        }

        return false
    }
}