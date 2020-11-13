package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.EditText
import android.widget.TextView
import java.util.*

class OtherActivity2 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other2)
        findViewById<TextView>(R.id.finalFirstName).setText("First Name: ${(intent.getStringExtra("firstName"))}")
        findViewById<TextView>(R.id.finalLastName).setText("Last Name: ${( intent.getStringExtra("lastName"))}")
        findViewById<TextView>(R.id.finalEmail).setText("Email: ${( intent.getStringExtra("email"))}")
        findViewById<TextView>(R.id.finalAge).setText("Age: ${( intent.getStringExtra("age"))}")
        findViewById<TextView>(R.id.finalPhoneNumber).setText("Number: ${ (intent.getStringExtra("phoneNumber"))}")
        findViewById<TextView>(R.id.finalBirthdate).setText("Birthday: ${( intent.getStringExtra("birthDate") )}")

        }
        }