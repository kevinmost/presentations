package com.kevinmost.ankodemo.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.kevinmost.ankodemo.R
import org.jetbrains.anko.*

class CounterView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){
    var currentCount: Int = 0
        private set

    var onCounterUpdatedListener: (Int) -> Unit = {}

    init {
        orientation = VERTICAL
        val counterTextView = textView {
            gravity = Gravity.CENTER_HORIZONTAL
            textSize = 36F
            textColor = ContextCompat.getColor(context, android.R.color.holo_green_dark)
            text = "0"
        }
        button {
            textResource = R.string.increment
            onClick {
                currentCount++
                onCounterUpdatedListener(currentCount)
                counterTextView.text = currentCount.toString()
            }
        }
    }

}
