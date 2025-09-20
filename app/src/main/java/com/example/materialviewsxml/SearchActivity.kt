package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.search_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Actionbarとして設定する
        setSupportActionBar(findViewById<SearchBar>(R.id.search_bar_action_bar))
        // SearvhViewを表示する
        val searchBar = findViewById<SearchBar>(R.id.search_bar)
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
        // メニューを表示する
        val searchBarMenu =  findViewById<SearchBar>(R.id.search_bar_menu)
        searchBarMenu.inflateMenu(R.menu.bottom_navigation_menu)
    }

    // ActionBarとして設定したSearchbarにメニューを設定する
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }


    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }
}