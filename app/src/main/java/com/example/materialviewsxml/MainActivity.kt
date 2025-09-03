package com.example.materialviewsxml

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.materialviewsxml.pager.MainPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = MainPagerAdapter(
            this,
        )
        findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager).apply {
            this.adapter = adapter
        }
        val viewPager = findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = createTabTitle(position)
        }.attach()
    }

        private fun createTabTitle(position: Int): String {
            return when (position) {
                PAGE_BASE_COMPONENT -> getString(R.string.tab_base_component)
                PAGE_COMPONENT -> getString(R.string.tab_component)
                PAGE_OTHER -> getString(R.string.tab_other)
                else -> getString(R.string.tab_component)
            }
        }

    companion object {
        const val PAGE_BASE_COMPONENT = 0
        const val PAGE_COMPONENT = 1
        const val PAGE_OTHER = 2
    }
}