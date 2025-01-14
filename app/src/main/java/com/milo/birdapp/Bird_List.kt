package com.milo.birdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Bird_List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird_list)

        //Kingfisher
        val imgButton = findViewById<ImageButton>(R.id.imageButton)
        imgButton.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,
                Kingfisher::class.java)
            startActivity(intent)
        })
        //Peacock
        val imgButton1 = findViewById<ImageButton>(R.id.imageButton2)
        imgButton1.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,
                Peacock::class.java)
            startActivity(intent)
        })
        //Weaver
        val imgButton2 = findViewById<ImageButton>(R.id.imageButton3)
        imgButton2.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,
                Weaver::class.java)
            startActivity(intent)
        })
        //Owl
        val imgButton3 = findViewById<ImageButton>(R.id.imageButton4)
        imgButton3.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,
                Owl::class.java)
            startActivity(intent)
        })
        //Toucan
        val imgButton5 = findViewById<ImageButton>(R.id.imageButton5)
        imgButton5.setOnClickListener(View.OnClickListener {

            val intent = Intent(
                this,
                Toucan::class.java
            )
            startActivity(intent)
        })
        //Pigeon
        val imgButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imgButton6.setOnClickListener(View.OnClickListener {

            val intent = Intent(
                this,
                Pigeon::class.java
            )
            startActivity(intent)
        })
        //View button will take you to the view page
        val NavBtn1 = findViewById<Button>(R.id.button5)
        NavBtn1.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,com.milo.birdapp.View::class.java)
            startActivity(intent)

        })
        //View button will take you to the settings page
        val NavBtn2 = findViewById<Button>(R.id.button9)
        NavBtn2.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,settings::class.java)
            startActivity(intent)

        })
    }
}