package com.example.resetpassscreen

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dateOfBirthPlaceholderTextView: TextView
    private var calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateOfBirthPlaceholderTextView = findViewById(R.id.dateOfBirthPlaceholderTextView)

        // Set OnClickListener for Date of Birth Placeholder TextView
        dateOfBirthPlaceholderTextView.setOnClickListener {
            showDatePickerDialog()
        }

        // Find the "Next" button and set OnClickListener to navigate to com.example.resetpassscreen.MainActivity2
        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                // Set the selected date to the placeholder TextView
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, day)
                val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                dateOfBirthPlaceholderTextView.text = formattedDate
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}
