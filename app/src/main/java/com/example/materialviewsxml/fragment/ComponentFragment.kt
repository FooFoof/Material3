package com.example.materialviewsxml.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.materialviewsxml.ButtonActivity
import com.example.materialviewsxml.CardActivity
import com.example.materialviewsxml.CarouselActivity
import com.example.materialviewsxml.CheckboxActivity
import com.example.materialviewsxml.ChipsActivity
import com.example.materialviewsxml.MenuActivity
import com.example.materialviewsxml.PickerActivity
import com.example.materialviewsxml.ProgressIndicatorActivity
import com.example.materialviewsxml.R
import com.example.materialviewsxml.RadioButtonActivity
import com.example.materialviewsxml.SearchActivity
import com.example.materialviewsxml.SliderActivity
import com.example.materialviewsxml.SwitchActivity
import com.example.materialviewsxml.TextFieldActivity
import com.example.materialviewsxml.ToolbarActivity
import com.google.android.material.button.MaterialButton

class ComponentFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.button_zero).setOnClickListener {
            startActivity(ButtonActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_card).setOnClickListener {
            startActivity(CardActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_checkbox).setOnClickListener {
            startActivity(CheckboxActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_toolbar).setOnClickListener {
            startActivity(ToolbarActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_switch).setOnClickListener {
            startActivity(SwitchActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_slider).setOnClickListener {
            startActivity(SliderActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_text_filed).setOnClickListener {
            startActivity(TextFieldActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_carousel).setOnClickListener {
            startActivity(CarouselActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_chips).setOnClickListener {
            startActivity(ChipsActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_menu).setOnClickListener {
            startActivity(MenuActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_date_picker).setOnClickListener {
            startActivity(PickerActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_radio_button).setOnClickListener {
            startActivity(RadioButtonActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_search).setOnClickListener {
            startActivity(SearchActivity.intent(requireContext()))
        }
        view.findViewById<Button>(R.id.button_progress_indicator).setOnClickListener {
            startActivity(ProgressIndicatorActivity.intent(requireContext()))
        }
    }

}
