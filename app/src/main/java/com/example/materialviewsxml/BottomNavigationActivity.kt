package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView


class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottom_navigation_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val badgeNum = findViewById<NavigationBarView>(R.id.bottom_navigation).getOrCreateBadge(R.id.item_2)
        badgeNum.isVisible = true
        badgeNum.number = 99
        val badge = findViewById<NavigationBarView>(R.id.bottom_navigation).getOrCreateBadge(R.id.item_1)
        badge.isVisible = true
        findViewById<NavigationBarView>(R.id.bottom_navigation).selectedItemId = R.id.item_2
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {

                    // Respond to navigation item 1 click
                    true
                }

                R.id.item_2 -> {
                    // Respond to navigation item 2 click
                    true
                }

                else -> false
            }
        }
//        findViewById<NavigationBarView>(R.id.bottom_navigation_18).setOnItemReselectedListener { item ->
//            when(item.itemId) {
//                R.id.item_1 -> {
//                    // Respond to navigation item 1 reselection
//                }
//                R.id.item_2 -> {
//                    // Respond to navigation item 2 reselection
//                }
//            }
//        }
    }


    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, BottomNavigationActivity::class.java)
        }
    }
}