package com.milo.birdapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Achievements : AppCompatActivity() {
    private lateinit var achievementImage1: ImageView
    private lateinit var achievementImage2: ImageView
    private lateinit var achievementImage3: ImageView
    // graph button declaration
    lateinit var goBarChart: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)


        achievementImage1 = findViewById(R.id.imageView10)
        achievementImage2 = findViewById(R.id.imageView11)
        achievementImage3 = findViewById(R.id.imageView12)

        //Check the condition for each achievement and set visibility accordingly
        if (isAchievementUnlocked1()) {
            achievementImage1.visibility = View.VISIBLE
            showToast("Achievement 1 unlocked!")
        }

        if (isAchievementUnlocked2()) {
            achievementImage2.visibility = View.VISIBLE
            showToast("Achievement 2 unlocked!")
        }

        if (isAchievementUnlocked3()) {
            achievementImage3.visibility = View.VISIBLE
            showToast("Achievement 3 unlocked!")
        }

    }

    // Function to check if achievement 1 is unlocked
    private fun isAchievementUnlocked1(): Boolean {
        val achievement1Threshold = 100 // Change this to your desired threshold
        val currentCount = 120 // Change this to the actual count you want to check
        return currentCount >= achievement1Threshold
    }

    // Function to check if achievement 2 is unlocked
    private fun isAchievementUnlocked2(): Boolean {
        val achievement2Threshold = 200 // Change this to your desired threshold
        val currentCount = 220 // Change this to the actual count you want to check
        return currentCount >= achievement2Threshold
    }

    // Function to check if achievement 3 is unlocked
    private fun isAchievementUnlocked3(): Boolean {
        val achievement3Threshold = 300 // Change this to your desired threshold
        val currentCount = 350 // Change this to the actual count you want to check
        return currentCount >= achievement3Threshold
    }

    // Function to show a Toast message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}



