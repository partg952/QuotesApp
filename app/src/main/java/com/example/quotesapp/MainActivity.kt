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

private lateinit var btn:Button
private lateinit var email:EditText
private lateinit var password:EditText
private lateinit var text:TextView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btn = findViewById<Button>(R.id.button)
    email = findViewById<EditText>(R.id.editTextTextEmailAddress)
    password = findViewById<EditText>(R.id.editTextNumberPassword)
    text = findViewById<TextView>(R.id.textView)

    text.setOnClickListener {
      var intent = Intent(this@MainActivity,SignIn::class.java)
      startActivity(intent)
    }

    btn.setOnClickListener {
      if(email.text.isEmpty()||password.text.isEmpty()){
        return@setOnClickListener
      }
      else{
        var gmail = email.text.toString()
        var pass = password.text.toString()
        
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(gmail,pass)
          .addOnCompleteListener {
            if(it.isSuccessful){
              var int = 1
              var suffix = FirebaseAuth.getInstance().currentUser?.email?.removeSuffix("@gmail.com").toString()
              var ref = FirebaseDatabase.getInstance().getReference().child("user").child(suffix).child("email")
              ref.setValue(gmail)
              var ref2 = FirebaseDatabase.getInstance().getReference().child("user").child(suffix).child(suffix)
              ref2.setValue(int)
              Toast.makeText(applicationContext,"Sign Up Success",Toast.LENGTH_SHORT).show()
              var intent2 = Intent(this@MainActivity,QuoteActivity::class.java)
              intent2.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
              startActivity(intent2)
            }
            else{
              Toast.makeText(applicationContext,"Sign Up Failed",Toast.LENGTH_SHORT).show()
            }
          }
      }
    }


  }
}