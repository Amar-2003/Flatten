
package com.thedevelopers.Flatten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.signout_test).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
        val bottomNavigationView: BottomNavigationView=findViewById(R.id.bottomNavigationView)
        val navController =findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
        fun onBackPressed(){
            System.exit(-1)
        }
    }
}