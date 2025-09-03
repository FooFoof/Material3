package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigationrail.NavigationRailView

class NavigationRailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navigation_rail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.navigation_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<NavigationBarView>(R.id.navigation_rail).setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_3 -> {
                    findViewById<NavigationRailView>(R.id.navigation_rail).expand()
                    true
                }
                R.id.item_4 -> {
                    // Respond to schedule navigation item click
                    findViewById<NavigationRailView>(R.id.navigation_rail).collapse()
                    true
                }
                else -> false
            }
        }
    }
    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, NavigationRailActivity::class.java)
        }
    }
}
