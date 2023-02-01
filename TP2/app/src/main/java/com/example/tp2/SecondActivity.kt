package com.example.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// Type : Activity
/*class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView: TextView = findViewById(R.id.textView)
    }
}*/

// Type : Fragment
class SecondActivity : Fragment(R.layout.activity_second) {

    // Defining the list we will use in recyclerview
    private var list: MutableList<String> = mutableListOf()
    //
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //list = mutableListOf("item 1", "item 2", "item 3")
/*
        // first time launching the app we get the init list
        if (savedInstanceState == null){
            list = mutableListOf("item 1", "item 2", "item 3")
        } else{
            // Calling the list that is saved in savedInstanceState that's called "list"
            list = savedInstanceState.getStringArrayList("list") ?: mutableListOf("item 1", "item 2", "item 3")
        }*/


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = view.findViewById(R.id.textView)

        // Button to go back to the first fragment
        val button : Button = view.findViewById(R.id.button)

        // Navigate to Fragment 1
        button.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_secondActivity_to_monFragment)
        }

        //ViewModel
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Recyclerview
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        // Specifying a layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //val list = mutableListOf("item 1", "item 2", "item 3")
        val adapter = CustomAdapter(list)
        recyclerView.adapter = adapter

        viewModel.items.observe(this, Observer{
            adapter.updateData(it)
        })

        // Button that will add an element to the list
        val addCell : Button = view.findViewById(R.id.addCell)
        addCell.setOnClickListener {
            viewModel.addItem("new item")
            // Whenever an element is added we need to notify the adapter
            //adapter.notifyDataSetChanged()
        }


    }
    /*
    // we store list in savedInstance so we will use it when we rotate the phone
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList("list", ArrayList(list))
        super.onSaveInstanceState(outState)
    }*/



}