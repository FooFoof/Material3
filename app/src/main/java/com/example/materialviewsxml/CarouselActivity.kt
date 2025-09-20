package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialviewsxml.adapter.CarouselRecyclerAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import com.google.android.material.carousel.UncontainedCarouselStrategy
import com.google.android.material.divider.MaterialDividerItemDecoration

class CarouselActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carousel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.carousel_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<RecyclerView>(R.id.recycler_multi).apply {
            layoutManager = CarouselLayoutManager()
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_uncontained).apply {
            layoutManager = CarouselLayoutManager(UncontainedCarouselStrategy())
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_hero).apply {
            layoutManager = CarouselLayoutManager(HeroCarouselStrategy())
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_hero_center).apply {
            layoutManager = CarouselLayoutManager(HeroCarouselStrategy()).apply {
                carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
            }
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_small_size_min).apply {
            val strategy =  HeroCarouselStrategy().apply {
                smallItemSizeMin = 12f
            }
            layoutManager = CarouselLayoutManager(strategy)
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_small_size_min_36).apply {
            val strategy = HeroCarouselStrategy().apply {
                smallItemSizeMin = 36f
            }
            layoutManager = CarouselLayoutManager(strategy)
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_small_size_max_24).apply {
            val strategy = HeroCarouselStrategy().apply {
                smallItemSizeMax = 24f
            }
            layoutManager = CarouselLayoutManager(strategy)
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_small_size_max_36).apply {
            val strategy = HeroCarouselStrategy().apply {
                smallItemSizeMax = 36f
            }
            layoutManager = CarouselLayoutManager(strategy)
            adapter = CarouselRecyclerAdapter()
        }
        findViewById<RecyclerView>(R.id.recycler_full).apply {
            layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy(), RecyclerView.VERTICAL)
            adapter = CarouselRecyclerAdapter()
            val divider = MaterialDividerItemDecoration(context!!, LinearLayoutManager.VERTICAL)
            divider.isLastItemDecorated = false
            addItemDecoration(divider)
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, CarouselActivity::class.java)
        }
    }
}