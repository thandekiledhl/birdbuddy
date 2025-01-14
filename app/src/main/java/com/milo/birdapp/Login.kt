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


class Login : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    private lateinit var btnSave: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val NavBtn1 = findViewById<Button>(R.id.button3)
        NavBtn1.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, Bird_List::class.java)
            startActivity(intent)
        })

        etEmail = findViewById(R.id.editTextTextEmailAddress2)
        etPassword = findViewById(R.id.editTextTextPassword)


        dbRef = FirebaseDatabase.getInstance().getReference("Users") //database name

    }

    private fun saveUsersData() {
        //getting user details
        val editTextTextEmailAddress2 = etEmail.text.toString()
        val editTextTextPassword = etPassword.text.toString()


        if (editTextTextEmailAddress2.isEmpty()) {
            etEmail.error = "Please enter email."
        }
        if (editTextTextPassword.isEmpty()) {
            etPassword.error = "Please enter password."

            val userId = dbRef.push().key!!

            val user = UserModel(editTextTextEmailAddress2, editTextTextPassword)

            dbRef.child(userId).setValue(user)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }

            val NavBtn1 = findViewById<Button>(R.id.button4)
            NavBtn1.setOnClickListener(View.OnClickListener {

                val intent = Intent(this, Bird_List::class.java)
                startActivity(intent)
            })
        }
    }
}