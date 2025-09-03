package com.example.materialviewsxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_CLOCK
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar
import java.util.TimeZone

class PickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_picker)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.date_picker_actions)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // DatePicker/単一選択
        findViewById<MaterialButton>(R.id.button_date_single_picker).setOnClickListener {
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select dates")
                .build()
                .show(supportFragmentManager, TAG)
        }

        // DatePicker/範囲選択
        findViewById<MaterialButton>(R.id.button_date_some_picker).setOnClickListener {
            MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select dates")
                .setSelection(
                    androidx.core.util.Pair(
                        // 現在の月の1日から現在の日付を選択する、
                        MaterialDatePicker.thisMonthInUtcMilliseconds(),
                        MaterialDatePicker.todayInUtcMilliseconds()
                    )
                )
                .build()
                .show(supportFragmentManager, TAG)
        }
        // テキスト入力モードで起動
        findViewById<MaterialButton>(R.id.button_date_text_input_picker).setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                .build()
            datePicker.show(supportFragmentManager, TAG)
        }

        // カレンダーの表示範囲を現在の年の1月から12月制限する
        findViewById<MaterialButton>(R.id.button_date_picker_decorator).setOnClickListener {
            val today = MaterialDatePicker.todayInUtcMilliseconds()
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

            calendar.timeInMillis = today
            calendar[Calendar.MONTH] = Calendar.JANUARY
            val janThisYear = calendar.timeInMillis

            calendar.timeInMillis = today
            calendar[Calendar.MONTH] = Calendar.DECEMBER
            val decThisYear = calendar.timeInMillis

            // 制約を作成
            val constraintsBuilder =
                CalendarConstraints.Builder()
                    .setStart(janThisYear)
                    .setEnd(decThisYear)
                    .build()

            // DatePickerに制約をセットして表示
            MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(constraintsBuilder)
                .build()
                .show(supportFragmentManager, TAG)

        }
        // 表示時、表示される月を指定する
        findViewById<MaterialButton>(R.id.button_date_picker_default_month).setOnClickListener {
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar[Calendar.MONTH] = Calendar.FEBRUARY
            val february = calendar.timeInMillis

            // 表示時、表示される月を2月に設定する制約を作成
            val constraintsBuilder =
                CalendarConstraints.Builder()
                    .setOpenAt(february)
                    .build()

            // DatePickerに制約をセットして表示
            MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(constraintsBuilder)
                .build()
                .show(supportFragmentManager, TAG)
        }
        // 週の最初の曜日を設定する
        findViewById<MaterialButton>(R.id.button_date_picker_first_day_of_week).setOnClickListener {
            val constraintsBuilder =
                CalendarConstraints.Builder()
                    .setFirstDayOfWeek(Calendar.WEDNESDAY)
                    .build()

            // DatePickerに制約をセットして表示
            MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(constraintsBuilder)
                .build()
                .show(supportFragmentManager, TAG)
        }

        // テーマを設定する
        findViewById<MaterialButton>(R.id.button_date_picker_custom_theme).setOnClickListener {
            MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select dates")
                .setTheme(R.style.ThemeOverlay_App_DatePicker)
                .build()
                .show(supportFragmentManager, TAG)
        }

        // TimePicker/時計モードで起動する
        findViewById<MaterialButton>(R.id.button_time_picker).setOnClickListener {
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setHour(12) // 時間の初期値
                    .setMinute(10) // 分の初期値
                    .setTitleText("Select Appointment time")
                    .setInputMode(INPUT_MODE_CLOCK) // 時計モードで起動する
                    .build()
                    .show(supportFragmentManager, TAG)
        }

        // 24時間表示のタイムピッカー
        findViewById<MaterialButton>(R.id.button_time_picker_24).setOnClickListener {
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12) // 時間の初期値
                .setMinute(10) // 分の初期値
                .setTitleText("Select Appointment time")
                .setInputMode(INPUT_MODE_KEYBOARD) // 入力モードで起動する
                .build()
                .show(supportFragmentManager, TAG)
        }

        // テーマを設定する
        findViewById<MaterialButton>(R.id.button_time_picker_custom).setOnClickListener {
                MaterialTimePicker.Builder()
                    .setTheme(R.style.Widget_App_TimePicker_Clock)
                    .build()
                    .show(supportFragmentManager, TAG)
        }
    }

        companion object {
            fun intent(context: Context): Intent {
                return Intent(context, PickerActivity::class.java)
            }

            val TAG = "tag"
        }
    }