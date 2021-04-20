package com.example.dyschat

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import java.lang.Error

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email_field = findViewById<EditText>(R.id.email_text_register)
        var password_field = findViewById<EditText>(R.id.password_text_register)
        var username_field = findViewById<EditText>(R.id.username_text_register)
        var register_button = findViewById<Button>(R.id.register_button_register)
        var have_account = findViewById<TextView>(R.id.have_account_textview_register)
        var error_field = findViewById<TextView>(R.id.ErrorCodes)


//     ButtonClickRegister
        register_button.setOnClickListener {
            val email = email_field.text.toString()
            val password = password_field.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                error_field.setText("Fields cannot be empty")
                return@setOnClickListener
            }

            Log.d("MainActivity","Email is: "+ email)
            Log.d("MainActivity","Password is: "+ password)
            // Connecting to firebase
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)

                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Log.d("Main", "Successfully logged in with uid: ${it.result?.user?.uid}")
                        error_field.setTextColor(Color.GREEN)
                        error_field.setText("Created account successfully")
                        return@addOnCompleteListener
                    }
                    else{
                        Log.d("Main", "Fail")
                        error_field.setText("Account creation failed")
                    }

                }


        }

        have_account.setOnClickListener {
            Log.d("MainActivity", "Has Account")
            //launching login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }


    }

}