package com.example.materialviewsxml.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialviewsxml.R
import com.google.android.material.color.DynamicColors
import com.google.android.material.snackbar.Snackbar

class OtherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_snackbar).setOnClickListener {
            Snackbar.make(
                requireActivity().findViewById(R.id.main),
                resources.getText(R.string.snackbar_text),
                Snackbar.LENGTH_LONG
            ).setAction(
                resources.getText(R.string.snackbar_action)
            ) {
                Toast.makeText(requireContext(), resources.getText(R.string.snackbar_closed_message), Toast.LENGTH_LONG)
                    .show()
            }
                .show()
        }
        view.findViewById<Button>(R.id.button_dynamic_color).setOnClickListener {
            activateDynamicColors()
        }
    }

    private fun activateDynamicColors() {
        // API 31 (Android 12) 以降でダイナミックカラーを有効にする
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            DynamicColors.applyToActivitiesIfAvailable(requireActivity().application)
            Snackbar.make(
                requireActivity().findViewById(R.id.main),
                resources.getText(R.string.snackbar_success_message),
                Snackbar.LENGTH_LONG
            ).show()
        } else {
            Snackbar.make(
                requireActivity().findViewById(R.id.main),
                resources.getText(R.string.snackbar_error_message),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}