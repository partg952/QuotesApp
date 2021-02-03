package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Manager(private val context: Context?, private val array: ArrayList<String>) : RecyclerView.Adapter<Manager.ViewHolder>() {
  
  inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
  var text = itemView.findViewById<TextView>(R.id.textView3)
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    var view = LayoutInflater.from(context).inflate(R.layout.card,parent,false)
    
    return ViewHolder(view)
  }
  
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   var current = array[position]
    holder.text.text = current
  }
  
  override fun getItemCount() = array.size
  
  
}
