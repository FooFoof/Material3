package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class ChipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chips)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.chips_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val chip = findViewById<Chip>(R.id.chip_1)
        chip.layoutDirection = View.LAYOUT_DIRECTION_LOCALE

        findViewById<MaterialButton>(R.id.button_make_chip).setOnClickListener {
            setEditTextChipDrawable()
        }
    }

    private fun setEditTextChipDrawable() {
        val editText = findViewById<android.widget.EditText>(R.id.edit_text)
        val span = ImageSpan(makeChipDrawable())
        val text = editText.text!!
        val cursorEnd = editText.selectionEnd // カーソルの終端位置
        editText.text.insert(cursorEnd, "  ") //カーソル位置にチップを設定するスペースと、チップの右側のスペース用にスペースを設定
        text.setSpan(span, cursorEnd,  cursorEnd + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    private fun makeChipDrawable(): ChipDrawable {
        val chipDrawable = ChipDrawable.createFromResource(this, R.xml.standalone_chip)
        chipDrawable.setTextAppearanceResource(R.style.text_standalone_chip)
        chipDrawable.text = getString(R.string.chip_label)
        chipDrawable.setBounds(0, 0, chipDrawable.intrinsicWidth, chipDrawable.intrinsicHeight)
        return chipDrawable
    }


    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, ChipsActivity::class.java)
        }
    }
}