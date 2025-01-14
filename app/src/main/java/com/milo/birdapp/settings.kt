package com.milo.birdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val NavBtn16 = findViewById<Button>(R.id.button6)
        NavBtn16.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,Achievements::class.java)
            startActivity(intent)

        })
    }
}