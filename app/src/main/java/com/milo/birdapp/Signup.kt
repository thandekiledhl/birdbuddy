package com.milo.birdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Signup : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSave: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val NavBtn1 = findViewById<Button>(R.id.button4)
        NavBtn1.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, Bird_List::class.java)
            startActivity(intent)
        })

        etEmail = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword2)
        etConfirmPassword = findViewById(R.id.editTextTextPassword3)

        dbRef = FirebaseDatabase.getInstance().getReference("Users") //database name

    }
    private fun saveUsersData(){
        //getting user details
        val editTextTextEmailAddress = etEmail.text.toString()
        val editTextTextPassword2 = etPassword.text.toString()
        val editTextTextPassword3 = etConfirmPassword.text.toString()

        if (editTextTextEmailAddress.isEmpty()){
            etEmail.error = "Please enter email."
        }
        if (editTextTextPassword2.isEmpty()){
            etPassword.error = "Please enter password."
        }
        if (editTextTextPassword3.isEmpty()){
            etConfirmPassword.error = "Please confirm password."
        }

        val userId = dbRef.push().key!!

        val user = UserModel(editTextTextEmailAddress, editTextTextPassword2, editTextTextPassword3)

        dbRef.child(userId).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this,"Data inserted successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

        val NavBtn1 = findViewById<Button>(R.id.button4)
        NavBtn1.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,Bird_List::class.java)
            startActivity(intent)
        })
    }
}