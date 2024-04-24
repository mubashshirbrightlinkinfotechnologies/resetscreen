package com.example.resetpassscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.app.DatePickerDialog
import android.widget.Button
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {

    private var clickedTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val startDatePlaceholderTextView = findViewById<TextView>(R.id.startDatePlaceholderTextView)
        val endDatePlaceholderTextView = findViewById<TextView>(R.id.endDatePlaceholderTextView)

        startDatePlaceholderTextView.setOnClickListener {
            clickedTextView = startDatePlaceholderTextView
            showDatePickerDialog()
        }

        endDatePlaceholderTextView.setOnClickListener {
            clickedTextView = endDatePlaceholderTextView
            showDatePickerDialog()
        }

        val previousButton = findViewById<Button>(R.id.previousButton)
        previousButton.setOnClickListener {
            finish() // Finish the current activity and return to the previous one
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Handle the selected date
            val selectedDate = Calendar.getInstance()
            selectedDate.set(selectedYear, selectedMonth, selectedDay)

            // Update the text of the clicked TextView with the selected date
            val selectedDateFormatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate.time)
            clickedTextView?.text = selectedDateFormatted
        }, year, month, day)

        datePickerDialog.show()


    }
}
