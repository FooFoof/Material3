package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.slider.RangeSlider

class SliderActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_slider)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_slider)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<RangeSlider>(R.id.slider3).apply {
            values = arrayListOf(20f, 80f)
        }
    }

    data class UiState(
        val sliderValue: Float = 0f,
        val rangeSliderValue: List<Float> = listOf(20f, 80f)
    )

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, SliderActivity::class.java)
        }
    }
}