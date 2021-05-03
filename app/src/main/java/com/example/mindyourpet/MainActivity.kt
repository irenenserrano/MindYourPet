package com.example.mindyourpet

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    // double check to see if you can use onCreate and onCreateView interchangeably
    // in codelab 7 task 4, step 2 things are meant to be added to the onCreateView method
    // but I do not have that method in main activity, i have onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_top, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var id = item.itemId
//        if (id == R.id.delete_button) {
//            Toast.makeText(this, "item clicked", Toast.LENGTH_LONG).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }

}