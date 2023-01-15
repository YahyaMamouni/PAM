package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MonFragment : Fragment(R.layout.fragment_first) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Contenu de MainActivity


        // Get color
        val color = resources.getColor(R.color.personal_color, null)

        // we use view. in fragment
        // we don't need to specify each time in an activity class because it's already present
        val textView : TextView = view.findViewById(R.id.textView)
        val editText : TextView = view.findViewById(R.id.editText)
        val button : Button = view.findViewById(R.id.button)
        //val secondButton : Button = view.findViewById(R.id.secondButton)
        val thirdButton : Button = view.findViewById(R.id.thirdButton)
        // This button is to navigate to destination
        val fourthButton : Button = view.findViewById(R.id.fourthButton)

        // Waiting for the button to get clicked
        button.setOnClickListener {
            textView.text = editText.text
            button.setBackgroundColor(color)
            // Display a Toast
            Toast.makeText(requireContext(), "Task completed", Toast.LENGTH_SHORT).show()
        }

        // Second fragment will be launched from the main activity and not from inside the first fragment

        // Waiting for the button to get clicked so we can switch to the second activity
        //secondButton.setOnClickListener {
            //val intent = Intent(requireContext(), SecondActivity::class.java)
            //startActivity(intent)
        //}

        thirdButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

        // Calling the nav_graph & navigate to destination (Fragment 2)
        fourthButton.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_monFragment_to_secondActivity)
        }

    }

}