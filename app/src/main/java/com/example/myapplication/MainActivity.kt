package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Seek Bar
        val step = 1 // 1 step per scroll
        val max = 60 //Maximum age
        val min = 18 //Minimum age
        val seekBar : SeekBar = findViewById(R.id.ageSeekBar) as SeekBar
        seekBar.setMax((max - min) / step)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, fromUser: Boolean) {
                val value = (min + (i * step))
                findViewById<TextView>(R.id.ageTextView).setText("$value")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,"Age: ${findViewById<TextView>(R.id.ageTextView).text}",Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,"Age: ${findViewById<TextView>(R.id.ageTextView).text}",Toast.LENGTH_SHORT).show()
            }
        })
        //Continue button listener that will execute continueToNextActivity function with 4 parameters
        findViewById<Button>(R.id.continueBtn).setOnClickListener{ continueToNextActivity(
                //Parameters
                findViewById<EditText>(R.id.firstNameEditText).text.toString(), //First name
                findViewById<EditText>(R.id.lastNameEditText).text.toString(), //Last name
                findViewById<EditText>(R.id.emailEditText).text.toString(), //Email
                findViewById<TextView>(R.id.ageTextView).text.toString() //Age
        ) }
    }
    private fun continueToNextActivity(fname: String, lname: String, email: String, age: String) {
        val intent = Intent(this, Semioutpuyt::class.java)
        intent.putExtra("firstName", fname)
        intent.putExtra("lastName", lname)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        startActivity(intent)
    }
}

