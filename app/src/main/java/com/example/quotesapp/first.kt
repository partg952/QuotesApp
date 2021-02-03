package com.example.quotesapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private lateinit var list2:ListView

class first(context: Context) : Fragment() {
  
//  private lateinit var recyclerView: RecyclerView
  private var param1: String? = null
  private var param2: String? = null
  
  private var temp = temp()
  
  
 
  
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
					   savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
  
    var view =  inflater.inflate(R.layout.fragment_first, container, false)
    
   
    
    
   var recyclerView = view.findViewById<RecyclerView>(R.id.recycle)

   
    var suffix = FirebaseAuth.getInstance().currentUser?.email?.removeSuffix("@gmail.com")
    
  
  var array = arrayListOf<String>()
    
//    array.add("parth")
  
  
    var ref = FirebaseDatabase.getInstance().getReference().child("user")
    var ref2 = FirebaseDatabase.getInstance().getReference()
  
    
//    var adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,array)
  
    
  
    var getdata = object:ValueEventListener{
      var sb = StringBuilder()
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for(i in dataSnapshot.children){
          var value = i.child("num").getValue().toString()
//          var value = i.child("$suffix").getValue().toString().toInt()
          
          if(value=="null"){
          
          }
          else{var value = value.toInt()
            while(0<value){
              var quote = i.child("$value").getValue().toString()
              array.add(quote)
              value--
            }
            
            Log.d("Main","$value")
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = Manager(context,array)
            Log.d("Main", value.toString())
            sb.append("$value")
          }
          
        }

        
        
       
      
      }
      override fun onCancelled(error: DatabaseError) {
        Toast.makeText(context,"Unable To Fetch Data",Toast.LENGTH_SHORT).show()
      }
    
    
    
    }
    ref2.addValueEventListener(getdata)
  
    
  
    
    return view
    
  }
  private fun fetchdata(array:ArrayList<String>, context: Context, listView:ListView) {
     }
  }
  
  
  
  
