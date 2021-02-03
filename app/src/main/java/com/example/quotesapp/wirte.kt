package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private lateinit var edit:EditText
private lateinit var btn:Button


class Wirte : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_wirte)
    btn = findViewById<Button>(R.id.button6)
    edit = findViewById<EditText>(R.id.editTextTextPersonName)
    
    var num=0

    var ref = FirebaseDatabase.getInstance().getReference()
    var getdata = object:ValueEventListener{
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for(i in dataSnapshot.children){
          var num2 = i.child("num").getValue().toString()
          if(num2=="null"){
          
          }
          else{
            Log.d("Main2", num2)
            num=num2.toInt()
          }
        }
      }

      override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
      }

    }

    ref.addValueEventListener(getdata)
    
    btn.setOnClickListener {

      if(edit.text.isEmpty()||edit.text.toString()=="Name"){

      }
      else{
        var edit = edit.text.toString()
        num++
        var ref2 = FirebaseDatabase.getInstance().getReference().child("quotes").child("$num")
                ref2.setValue(edit)
        var ref3 = FirebaseDatabase.getInstance().getReference().child("quotes").child("num")
        ref3.setValue(num)
                .addOnCompleteListener {
                  if(it.isSuccessful){
                    Toast.makeText(applicationContext,"Your Quote Has Been Added!",Toast.LENGTH_SHORT).show()
                  }
                  else{
                    Toast.makeText(applicationContext,"There Was Some Error!",Toast.LENGTH_SHORT).show()
                  }
                }
      }

    }
  }
}