package com.kevinmost.ankodemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kevinmost.ankodemo.R
import kotlinx.android.synthetic.withoutAnko.view_counter.view.*


class CounterView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var currentCount = 0
        private set

    var onCounterUpdatedListener: (Int) -> Unit = {}

    init {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        orientation = VERTICAL
        inflate(context, R.layout.view_counter, this)

        incrementButtonView.setOnClickListener {
            currentCount++
            onCounterUpdatedListener(currentCount)
            counterTextView.text = currentCount.toString()
        }
    }
}
