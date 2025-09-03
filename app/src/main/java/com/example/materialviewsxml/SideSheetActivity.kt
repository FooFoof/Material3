package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.sidesheet.SideSheetBehavior
import com.google.android.material.sidesheet.SideSheetDialog

class SideSheetActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_side_sheet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.side_sheet_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sideSheet = findViewById<FrameLayout>(R.id.side_sheet)
        val standardSideSheetBehavior = SideSheetBehavior.from(sideSheet)
        findViewById<MaterialButton>(R.id.button).setOnClickListener {
            standardSideSheetBehavior.setCoplanarSiblingViewId(R.id.side_sheet_container)
            standardSideSheetBehavior.state = SideSheetBehavior.STATE_EXPANDED

        }
        val sideSheetDialog = SideSheetDialog(this)
        sideSheetDialog.setContentView(R.layout.side_sheet_content_layout)
        findViewById<MaterialButton>(R.id.button2).setOnClickListener {
            sideSheetDialog.show()
        }
    }


    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, SideSheetActivity::class.java)
        }
    }
}