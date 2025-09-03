package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.materialviewsxml.dialog.BottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_sheet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottom_sheet_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val standardBottomSheet = findViewById<LinearLayout>(R.id.standard_bottom_sheet)
        val standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)

        findViewById<Button>(R.id.button_standard_bottom_sheet).setOnClickListener {
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        findViewById<Button>(R.id.button_modal_bottom_sheet).setOnClickListener {
            showModalBottomSheet()
        }
    }

    private fun showModalBottomSheet() {
        val bottomSheetFragment = BottomSheet()
        bottomSheetFragment.setStyle(
            BottomSheetDialogFragment.STYLE_NORMAL,
            R.style.ModalBottomSheetDialog
        )
        bottomSheetFragment.show(supportFragmentManager, BottomSheet.TAG)
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, BottomSheetActivity::class.java)
        }
    }
}