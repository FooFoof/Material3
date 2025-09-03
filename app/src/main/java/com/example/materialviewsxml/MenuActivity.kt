package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextThemeWrapper
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ListPopupWindow
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // メニューアイテムを設定する。
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        (findViewById<TextInputLayout>(R.id.menu).editText as? MaterialAutoCompleteTextView)?.setSimpleItems(
            items
        )
        // デフォルトのテキストを設定する。
        (findViewById<TextInputLayout>(R.id.menu).editText as? MaterialAutoCompleteTextView)?.setText(
            "デフォルト",
            false
        )
        // listのアイテムのレイアウトを指定して、メニューアイテムをアダプター経由で設定する。
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        (findViewById<TextInputLayout>(R.id.menu_outline).editText as? AutoCompleteTextView)?.setAdapter(
            adapter
        )

        // リストポップアップウィンドウメニュー
        val listPopupWindow =
            ListPopupWindow(this, null, androidx.appcompat.R.attr.listPopupWindowStyle)
        // 「リストアップウィンドウメニューを表示する」ボタンとリストアップウィンドウメニューを紐づける。
        val listPopupWindowButton = findViewById<Button>(R.id.list_popup_button)
        listPopupWindow.anchorView = listPopupWindowButton

        // リストアップウィンドウメニューにアイテムを設定する。
        listPopupWindow.setAdapter(adapter)

        // リストアップウィンドウメニューアイテムのクリック時の処理を実装する
        listPopupWindow.setOnItemClickListener { _, _, _, _ ->
            listPopupWindow.dismiss()
        }
        listPopupWindowButton.setOnClickListener { v: View? -> listPopupWindow.show() }

        // ポップアップメニューを表示する
        findViewById<Button>(R.id.pop_up_menu_button).setOnClickListener { v: View ->
            showMenu(v, R.menu.sample_menu)
        }

        // TextViewにコンテキストメニューを登録する。
        registerForContextMenu(findViewById<TextView>(R.id.context_menu_tv))
    }

    // ポップアップメニュー
    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        // ポップアップメニューのスタイルを指定する。
        val popUpStyle = ContextThemeWrapper(this, R.style.theme_pop)
        val popup = PopupMenu(popUpStyle, v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            popup.dismiss()
            true
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
            Snackbar.make(
                findViewById(R.id.menu_container),
                resources.getText(R.string.menu_pop_up_menu_close),
                Snackbar.LENGTH_LONG
            ).show()
        }
        popup.show()
    }

    // コンテキストメニュー
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.sample_menu_2, menu)
        // メニュー項目を追加する。
        menu.add(R.string.menu_add_item)
            .setOnMenuItemClickListener { _ ->
                Toast.makeText(this, "ADDEDアイテム clicked", Toast.LENGTH_SHORT).show()
                true
            }
    }

    // コンテキストメニューアイテム押下時の動作
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_3 -> {
                // Respond to context menu item 1 click.
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.item_4 -> {
                // Respond to context menu item 2 click.
                Toast.makeText(this, "Item 4 clicked", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    // オーバーフローメニュー
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.sample_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_3 -> {
                // Respond to context menu item 1 click.
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.item_4 -> {
                // Respond to context menu item 2 click.
                Toast.makeText(this, "Item 4 clicked", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, MenuActivity::class.java)
        }
    }
}