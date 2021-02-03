package com.example.quotesapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class adapter(fm:FragmentManager, private var context: Context):FragmentPagerAdapter(fm) {
  override fun getCount(): Int {
    return 2
  }
  
  override fun getItem(position: Int): Fragment {
   return when(position){
      0->{
        first(context)
      }
	 1->{
	   second(context)
	 }
	else -> {
	  first(context)
	}
	
   }
    
    
  }
  
  override fun getPageTitle(position: Int): CharSequence? {
    when(position){
      0->{
        return "Quotes"
      }
	 1->{
	  return "Your Info"
	 }
    }
   
    return super.getPageTitle(position)
  }
  
  
}