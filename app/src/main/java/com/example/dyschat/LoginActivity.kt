package com.example.dyschat

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email_field = findViewById<EditText>(R.id.username_text_login)
        var password_field = findViewById<EditText>(R.id.password_text_login)
        var login_button = findViewById<Button>(R.id.loginbutton_login)
        var back_to_register = findViewById<TextView>(R.id.textView)

        login_button.setOnClickListener{
            val email = email_field.text.toString()
            val password = password_field.text.toString()
            Log.d("Main","Attenpting to login")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener()
//                .addOnFailureListener {  }

        }

        back_to_register.setOnClickListener {
            finish()
        }
    }
}
