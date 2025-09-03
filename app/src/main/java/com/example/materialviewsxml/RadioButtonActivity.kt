package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioButtonActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.radio_button_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, RadioButtonActivity::class.java)
        }
    }
}