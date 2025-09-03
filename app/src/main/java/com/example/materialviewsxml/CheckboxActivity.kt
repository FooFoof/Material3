package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.checkbox.MaterialCheckBox

class CheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_checkbox)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkbox_container)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            findViewById<MaterialCheckBox>(R.id.checkbox_child_2).errorAccessibilityLabel = this.getString(R.string.checkbox_error_text)


    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, CheckboxActivity::class.java)
        }
    }
}