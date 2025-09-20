package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.progressindicator.LinearProgressIndicator


class ProgressIndicatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_progress_indicator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.progress_indicator_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 確定インジケーターの進捗を設定する。
        val progressIndicator = findViewById<LinearProgressIndicator>(R.id.progress)
        val progressCircleIndicator = findViewById<CircularProgressIndicator>(R.id.circle_progress)
        findViewById<MaterialButton>(R.id.button_progress).setOnClickListener {
                progressIndicator.setIndeterminate(false)
                progressCircleIndicator.setIndeterminate(false)
                progressIndicator.setProgress(progressIndicator.progress + 20, true)
                progressCircleIndicator.setProgress(progressCircleIndicator.progress + 20, true)
        }
        findViewById<MaterialButton>(R.id.button_reset_progress).setOnClickListener {
            progressIndicator.setIndeterminate(false)
            progressCircleIndicator.setIndeterminate(false)
            progressIndicator.setProgressCompat(0, true)
            progressCircleIndicator.setProgressCompat(0, true)
        }
        // 不確定インジケーターにする。
        findViewById<MaterialButton>(R.id.button_loading).setOnClickListener {
            progressIndicator.setIndeterminate(true)
            progressCircleIndicator.setIndeterminate(true)
        }
        // 表示非表示
        val outWard = findViewById<LinearProgressIndicator>(R.id.outward)
        val inward = findViewById<LinearProgressIndicator>(R.id.inward)
        val outWardCircle = findViewById<CircularProgressIndicator>(R.id.outward_circle)
        val inWardCircle = findViewById<CircularProgressIndicator>(R.id.inward_circle)
        findViewById<MaterialButton>(R.id.button_visible).setOnClickListener {
            outWard.visibility.let {
                if (it == LinearProgressIndicator.VISIBLE) {
                    outWard.setVisibilityAfterHide(INVISIBLE)
                    outWard.hide()
                } else {
                    outWard.visibility = VISIBLE
                }
            }
            inward.visibility.let {
                if (it == LinearProgressIndicator.VISIBLE) {
                    inward.setVisibilityAfterHide(INVISIBLE)
                    inward.hide()
                } else {
                    inward.visibility = VISIBLE
                }
            }

            outWardCircle.visibility.let {
                if (it == CircularProgressIndicator.VISIBLE) {
                    outWardCircle.setVisibilityAfterHide(INVISIBLE)
                    outWardCircle.hide()
                } else {
                    outWardCircle.visibility = VISIBLE
                }
            }
            inWardCircle.visibility.let {
                if (it == CircularProgressIndicator.VISIBLE) {
                    inWardCircle.setVisibilityAfterHide(INVISIBLE)
                    inWardCircle.hide()
                } else {
                    inWardCircle.visibility = VISIBLE
                }
            }
        }
        // ボタン上のプログレスバーとテキストを入れ替える。
        val buttonText = findViewById<TextView>(R.id.button_text)
        val buttonProgress = findViewById<CircularProgressIndicator>(R.id.button_progress_curcular)
        val frame = findViewById<FrameLayout>(R.id.button_progress_frame)
        frame.setOnClickListener {
            if (buttonText.visibility == VISIBLE) {
                buttonText.visibility = GONE
                buttonProgress.visibility = VISIBLE
            } else {
                buttonText.visibility = VISIBLE
                buttonProgress.setVisibilityAfterHide(GONE)
                buttonProgress.hide()
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, ProgressIndicatorActivity::class.java)
        }
    }
}
