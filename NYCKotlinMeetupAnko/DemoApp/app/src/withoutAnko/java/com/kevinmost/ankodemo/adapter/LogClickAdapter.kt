package com.kevinmost.ankodemo.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kevinmost.ankodemo.CounterClickEvent
import com.kevinmost.ankodemo.R
import java.text.DateFormat

class LogClickAdapter(private val context: Context) : RecyclerView.Adapter<LogClickAdapter.Holder>() {

    private val logs = mutableListOf<CounterClickEvent>()

    fun logEvent(event: CounterClickEvent) {
        logs.add(0, event)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = logs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.view_counter_log_entry, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val (newValue, timeClicked) = logs[position]
        holder.timestampView.text = DateFormat.getTimeInstance().format(timeClicked)
        holder.detailsView.text = context.getString(R.string.increment_log_details, newValue)
        holder.root.setBackgroundColor(ContextCompat.getColor(
                holder.root.context,
                if (position % 2 == 0) android.R.color.transparent else R.color.light_gray
        ))
    }

    class Holder(val root: View) : RecyclerView.ViewHolder(root) {
        val timestampView: TextView = root.findViewById(R.id.logTimestampView) as TextView
        val detailsView: TextView = root.findViewById(R.id.logDetailsView) as TextView
    }
}
