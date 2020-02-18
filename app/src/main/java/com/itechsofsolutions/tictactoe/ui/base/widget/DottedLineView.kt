package com.itechsofsolutions.tictactoe.ui.base.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.itechsofsolutions.tictactoe.R
import com.itechsofsolutions.tictactoe.utils.helper.ViewUtils


/**
 * This is a custom view of dotted line
 * (as custom drawables with dash doesn't work well in the different devices)
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class DottedLineView : View {
    private var mPaint: Paint? = null
    private var mPath: Path? = null
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    constructor(context: Context) : super(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint?.color = ViewUtils.getColor(R.color.colorWhite)
        mPaint?.style = Paint.Style.STROKE
        mPaint?.strokeWidth = 4F
        mPaint?.pathEffect = DashPathEffect(floatArrayOf(5f, 10f), 0f)
        mPath = Path()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        this.mWidth = measuredWidth
        this.mHeight = measuredHeight
        mPath?.moveTo(0F, (this.mHeight / 2).toFloat())
        mPath?.quadTo((this.mWidth / 2).toFloat(), (this.mHeight / 2).toFloat(),
                this.mWidth.toFloat(), (this.mHeight / 2).toFloat())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(mPath!!, mPaint!!)
    }
}