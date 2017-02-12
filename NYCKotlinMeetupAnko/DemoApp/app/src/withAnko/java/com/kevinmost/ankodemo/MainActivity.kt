package com.kevinmost.ankodemo

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.ViewGroup
import com.kevinmost.ankodemo.adapter.LogClickAdapter
import com.kevinmost.ankodemo.view.CounterView
import org.jetbrains.anko.ctx
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout
import java.util.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val clickAdapter = LogClickAdapter()
        verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            customView<CounterView> {
                onCounterUpdatedListener = {
                    clickAdapter.logEvent(CounterClickEvent(it, Date()))
                }
            }
            recyclerView {
                lparams {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                }
                adapter = clickAdapter
                layoutManager = LinearLayoutManager(ctx)
            }
        }
    }
}