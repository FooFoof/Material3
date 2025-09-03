package com.example.materialviewsxml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.materialviewsxml.R

class BottomSheetRecyclerAdapter : RecyclerView.Adapter<BottomSheetRecyclerAdapter.BottomSheetViewHolder>() {

    private val items = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
        "Item 11",
        "Item 12",
        "Item 13",
        "Item 14",
        "Item 15",
        "Item 16",
        "Item 17",
        "Item 18",
        "Item 19",
        "Item 20",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bottom_sheet_recycler_item, parent, false)
        return BottomSheetViewHolder(view)
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        holder.textMember.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class BottomSheetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMember: TextView = itemView.findViewById(R.id.text_member)
    }
}