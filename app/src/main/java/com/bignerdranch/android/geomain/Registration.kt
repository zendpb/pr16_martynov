package com.bignerdranch.android.geomain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Registration : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

    }


    fun login(view: View) {
        if (email.text.toString() == "1" && password.text.toString() == "1")
        {
            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка!")
                .setMessage("Есть незаполненые поля!")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
    }
}