package com.macol_richard.animal.dialogexplorer

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialogButton = findViewById<Button>(R.id.btnAlertDialog)
        val datePickerButton = findViewById<Button>(R.id.btnDatePicker)
        val timePickerButton = findViewById<Button>(R.id.btnTimePicker)

        alertDialogButton.setOnClickListener {
            showAlertDialog()
        }

        datePickerButton.setOnClickListener {
            showDatePickerDialog()
        }

        timePickerButton.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alert Dialog")
        alertDialog.setMessage("Are you sure to confirm this payment?")
        alertDialog.setPositiveButton("OK") { _, _ ->
            showToast("Payment confirmed!")
        }
        alertDialog.setNegativeButton("Cancel") { _, _ ->
            showToast("Cancelled")
        }
        alertDialog.setNeutralButton("Maybe Later") { _, _ ->
            showToast("Not decided")
        }
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                showToast("Date selected: $selectedDay/${selectedMonth + 1}/$selectedYear")
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _, selectedHour, selectedMinute ->
                showToast("Time selected: $selectedHour:$selectedMinute")
            },
            hour,
            minute,
            true
        )
        timePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}