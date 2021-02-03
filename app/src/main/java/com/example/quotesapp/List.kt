package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private lateinit var list:ListView
class List : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    list = findViewById<ListView>(R.id.list)
    var array = arrayListOf<String>()
    
    var ref = FirebaseDatabase.getInstance().getReference().child("user")
    
    var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
    
    list.adapter = adapter
    
    var getdata = object:ValueEventListener{
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for(i in dataSnapshot.children){
          var email = i.child("email").getValue().toString()
          if(email=="null"){
          
          }
          else{
            array.add(email)
            adapter.notifyDataSetChanged()
          }
        }
      }
   
      override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
      }
  
    }
    
    ref.addValueEventListener(getdata)
  }
}