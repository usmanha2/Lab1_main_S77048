package com.example.lab1_main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editName = findViewById<EditText>(R.id.editName);  //for editText
        val btnPressMe = findViewById<Button>(R.id.btnPressMe) //for button
        val showHello = findViewById<TextView>(R.id.showHello) //for textView

        btnPressMe.setOnClickListener {
            val name = editName.text.toString().trim()
            if (name.isEmpty()){
                val toast = Toast.makeText(this, "PLease enter name described!!!", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                showHello.text = "Hello, $name"
            }
        }
    }
}