package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialviewsxml.adapter.BottomSheetRecyclerAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView

class TopAppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_app_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.top_app_bar_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar_page).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BottomSheetRecyclerAdapter()
        }
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.overflowIcon = ContextCompat.getDrawable(this, R.drawable.heart_plus_fill)

        val searchBar = findViewById<SearchBar>(R.id.search_bar_action_bar)
        val searchView = findViewById<SearchView>(R.id.search_view)
        searchView.inflateMenu(R.menu.bottom_navigation_menu)
        searchBar.setOnClickListener {
            searchView.visibility = View.VISIBLE
            searchView.show() // アニメーション付きで開く
        }
        // SearchViewを閉じたら非表示にする
        searchView.addTransitionListener { _, _, newState ->
            if (newState == SearchView.TransitionState.HIDDEN) {
                searchView.visibility = View.GONE
            }
        }
        searchView
            .editText
            .setOnEditorActionListener { _, _, _ ->
                searchBar.setText(searchView.text)
                searchView.hide()
                return@setOnEditorActionListener false
            }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, TopAppBarActivity::class.java)
        }
    }
}
