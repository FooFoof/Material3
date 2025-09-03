package com.example.materialviewsxml.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.materialviewsxml.BottomNavigationActivity
import com.example.materialviewsxml.BottomSheetActivity
import com.example.materialviewsxml.NavigationRailActivity
import com.example.materialviewsxml.R
import com.example.materialviewsxml.SideSheetActivity

class BaseComponentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base_component, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_bottom_sheet).setOnClickListener {
            startActivity(BottomSheetActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_bottom_navigation).setOnClickListener {
            startActivity(BottomNavigationActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_side_sheet).setOnClickListener {
            startActivity(SideSheetActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_navigation_rail).setOnClickListener {
            startActivity(NavigationRailActivity.intent(requireContext()))
        }
    }
}
