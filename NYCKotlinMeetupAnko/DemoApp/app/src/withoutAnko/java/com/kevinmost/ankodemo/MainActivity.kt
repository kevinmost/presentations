package com.kevinmost.ankodemo

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kevinmost.ankodemo.adapter.LogClickAdapter
import kotlinx.android.synthetic.withoutAnko.activity_main.*
import java.util.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val clickAdapter = LogClickAdapter(this)

        setContentView(R.layout.activity_main)

        logsList.adapter = clickAdapter
        logsList.layoutManager = LinearLayoutManager(this)
        counterView.onCounterUpdatedListener = {
            clickAdapter.logEvent(CounterClickEvent(it, Date()))
        }
    }
}
