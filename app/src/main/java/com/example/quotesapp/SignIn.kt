package com.example.quotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private lateinit var btn:Button
private lateinit var email:EditText
private lateinit var password:EditText
private lateinit var text:TextView


class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        password = findViewById<EditText>(R.id.editTextNumberPassword2)
        btn = findViewById<Button>(R.id.button2)


        btn.setOnClickListener {
            if(email.text.isEmpty()|| password.text.isEmpty()){
                return@setOnClickListener
            }
            else{
                var gmail = email.text.toString()
                var pass = password.text.toString()
                FirebaseAuth.getInstance().signInWithEmailAndPassword(gmail,pass)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                Toast.makeText(applicationContext,"Sign In Success",Toast.LENGTH_SHORT).show()
                                var intent2 = Intent(this@SignIn,QuoteActivity::class.java)
                                intent2.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(intent2)
                            }
                            else{
                                Toast.makeText(applicationContext,"Sign In Failed",Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }


    }
}