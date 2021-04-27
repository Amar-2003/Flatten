package com.thedevelopers.Flatten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.login_btn).setOnClickListener {
            val email = findViewById<EditText>(R.id.email_signin).text.toString()
            val password = findViewById<EditText>(R.id.password_signin).text.toString()
            if(email == null){
                Toast.makeText(this@LoginActivity,"Please Enter the Email Address",Toast.LENGTH_SHORT).show()
            }
            else if(password == null){
                Toast.makeText(this@LoginActivity,"Please enter your password",Toast.LENGTH_SHORT).show()
            }
            else{
                login(email,password)
            }
        }
    }

    private fun login(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this@LoginActivity,"Login Successful",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this@LoginActivity,"Login Failed",Toast.LENGTH_SHORT).show()

            }
        }
    }
}