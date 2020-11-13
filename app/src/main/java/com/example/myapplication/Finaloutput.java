package com.example.myapplication;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible

class OtherActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        //Date picker
        val picker: DatePicker = findViewById<DatePicker>(R.id.calendarView) as DatePicker
        var birthdate = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
        picker.init(1999, 11, 11, object: DatePicker.OnDateChangedListener{
        override fun onDateChanged(
        view: DatePicker?,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int
        ) {
        birthdate = "${picker.month + 1}/${picker.dayOfMonth}/${picker.year}"
        }
        })
        //Signup Button event listener that will execute signUp function with 6 parameters
        findViewById<Button>(R.id.signUpBtn).setOnClickListener{ signUp(
        //Parameters
        intent.getStringExtra("firstName").toString(), //First name
        intent.getStringExtra("lastName").toString(), //Second name
        intent.getStringExtra("email").toString(), //Email
        intent.getStringExtra("age").toString(), //Age
        findViewById<EditText>(R.id.phoneNumberEditText).text.toString(),  //Phone number
        birthdate //Birthdate
        )}
        //Switch view event listener with showPhoneNumberEditText function
        findViewById<Switch>(R.id.phoneNumberSwitch).setOnClickListener {showPhoneNumberEditText()}
        }
//Handles the showPhoneNumberEditText function. Because by default, phoneNumberEditText is not visible
private fun showPhoneNumberEditText() {
        val switch: Switch = findViewById<Switch>(R.id.phoneNumberSwitch) as Switch
        if (switch.isChecked() == true ) {
        findViewById<EditText>(R.id.phoneNumberEditText).isVisible = true
        } else if (switch.isChecked() == false ) {
        findViewById<EditText>(R.id.phoneNumberEditText).isVisible = false
        }
        }
//Handles the signUp function
private fun signUp(firstName: String, lastName: String, email: String, age: String, phoneNumber: String, birthDate: String) {
        val intent = Intent(this, Semioutput::class.java)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("birthDate", birthDate)
        //If statement to check if the switch is checked or not.
        val switch: Switch = findViewById<Switch>(R.id.phoneNumberSwitch) as Switch
        if (switch.isChecked() == true) {
        intent.putExtra("phoneNumber", phoneNumber)
        } else if (switch.isChecked() == false ) {
        intent.putExtra("phoneNumber", "No phone #.")
        }
        //Start activity
        startActivity(intent)
        }

        }
