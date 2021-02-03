package com.example.quotesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [second.newInstance] factory method to
 * create an instance of this fragment.
 */
class second(context: Context) : Fragment() {
  // TODO: Rename and change types of parameters
  private var param1: String? = null
  private var param2: String? = null
  
  
  
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
					   savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    var view =  inflater.inflate(R.layout.fragment_second, container, false)
  	
    var text = view.findViewById<TextView>(R.id.textView4)
    var btn = view.findViewById<Button>(R.id.button4)
    var btn2 = view.findViewById<Button>(R.id.button5)

    btn.setOnClickListener {
      var intent2 = Intent(context,List::class.java)
      startActivity(intent2)
    }

    btn2.setOnClickListener {
      var intent = Intent(context,Wirte::class.java)
      startActivity(intent)
    }
    
    var email = FirebaseAuth.getInstance().currentUser?.email
    
    text.text = email
    
    return view
  }
  
  
  }
