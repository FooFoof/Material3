package com.example.materialviewsxml.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialviewsxml.R
import com.example.materialviewsxml.adapter.BottomSheetRecyclerAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet() : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.modal_bottom_sheet_content, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.bottom_recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BottomSheetRecyclerAdapter()
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}