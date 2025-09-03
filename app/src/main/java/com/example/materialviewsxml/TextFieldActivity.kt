package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class TextFieldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_text_field)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.text_field_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<TextInputLayout>(R.id.filledTextField_error).error = "Error message"
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        (findViewById<TextInputLayout>(R.id.drop).editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, TextFieldActivity::class.java)
        }
    }
}