package com.example.quotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

private lateinit var tabLayout: TabLayout
private lateinit var view:ViewPager

class QuoteActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quote)
    tabLayout = findViewById<TabLayout>(R.id.tabLayout)
    view = findViewById<ViewPager>(R.id.view)
    
    view.adapter = adapter(supportFragmentManager,this@QuoteActivity)
    tabLayout.setupWithViewPager(view)
    
    if(FirebaseAuth.getInstance().uid==null){
      var intent3 = Intent(this@QuoteActivity,MainActivity::class.java)
      intent3.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
      startActivity(intent3)
    }
    
    
  }
  
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.nav,menu)
    return super.onCreateOptionsMenu(menu)
  }
  
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item?.itemId){
      R.id.button3->{
        FirebaseAuth.getInstance().signOut()
        var intent = Intent(this@QuoteActivity,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
      }
    }
    return super.onOptionsItemSelected(item)
  }
}