package com.example.tp2


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.findNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MyViewModel: ViewModel() {
    val items = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf("item 1", "item 2", "item 3")
    }

    fun addItem(item: String) {
        items.value?.add(item)
        items.value = items.value
    }
}


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        // Log added
        Log.d(TAG, "onCreate called")

        // Get color
        val color = resources.getColor(R.color.personal_color, null)


        val textView : TextView = findViewById(R.id.textView)
        val editText : TextView = findViewById(R.id.editText)
        val button : Button = findViewById(R.id.button)
        val secondButton : Button = findViewById(R.id.secondButton)
        val thirdButton : Button = findViewById(R.id.thirdButton)

        // Waiting for the button to get clicked
        button.setOnClickListener {
            textView.text = editText.text
            button.setBackgroundColor(color)
            // Display a Toast
            Toast.makeText(applicationContext, "Task completed", Toast.LENGTH_SHORT).show()
        }

        // Waiting for the button to get clicked so we can switch to the second activity
        secondButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        thirdButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
*/




        // Fragments as buttons
        /*
        val buttonFragement : Button = findViewById(R.id.buttonFragement)
        buttonFragement.setOnClickListener {
            val fragment = MonFragment()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

        // Second fragment (old second activity)
        val secondButtonFragement : Button = findViewById(R.id.secondButtonFragement)
        secondButtonFragement.setOnClickListener {
            val fragment = SecondActivity()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
        */





    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
    }
}