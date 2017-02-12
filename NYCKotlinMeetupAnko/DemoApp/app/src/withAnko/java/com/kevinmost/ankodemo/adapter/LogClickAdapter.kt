package com.kevinmost.ankodemo.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.kevinmost.ankodemo.CounterClickEvent
import com.kevinmost.ankodemo.R
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.textView
import java.text.DateFormat
import kotlin.properties.Delegates

class LogClickAdapter : RecyclerView.Adapter<LogClickAdapter.Holder>() {

    private val logs = mutableListOf<CounterClickEvent>()

    fun logEvent(event: CounterClickEvent) {
        logs.add(0, event)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = logs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(LogClickEntryView(parent.context))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.root.data = logs[position]
        holder.root.backgroundColor = ContextCompat.getColor(
                holder.root.context,
                if (position % 2 == 0) android.R.color.transparent else R.color.light_gray
        )
    }

    class Holder(val root: LogClickEntryView) : RecyclerView.ViewHolder(root)
}


class LogClickEntryView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var data by Delegates.observable<CounterClickEvent?>(null) { prop, old, data ->
        data?.let { new ->
            timestampView.text = DateFormat.getTimeInstance().format(new.timeClicked)
            detailsView.text = context.getString(R.string.increment_log_details, new.newValue)
        }
    }

    private lateinit var timestampView: TextView
    private lateinit var detailsView: TextView

    init {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        linearLayout {
            lparams(width = ViewGroup.LayoutParams.MATCH_PARENT)
            gravity = Gravity.CENTER_HORIZONTAL
            timestampView = textView {
                lparams {
                    weight = 1F
                }
            }
            detailsView = textView {
                lparams {
                    weight = 1F
                }
            }
        }
    }
}
