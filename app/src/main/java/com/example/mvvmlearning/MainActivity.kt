package com.example.mvvmlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Tell Activity as soon as it is created, it should notify the Observer,you can add mulitple observers
        lifecycle.addObserver(Observer())
//      lifecycle.addObserver(Observer())   // you can add mulitple observers

//       ViewModelProvider(this)  - this means the activity is the owner of the ViewModel

        viewModel = ViewModelProvider(this,MainViewModelFactory(-1)).get(MainViewModel::class.java)

        val textCounter = findViewById<TextView>(R.id.displayText)


        val btnIncrement = findViewById<TextView>(R.id.btnIncrement)

        val btnDecrement = findViewById<TextView>(R.id.btnDecrement)

        val btnReset = findViewById<TextView>(R.id.btnReset)


        btnIncrement.setOnClickListener {
            viewModel.increment()
            textCounter.text = viewModel.counter.toString()
        }


        btnDecrement.setOnClickListener {
            viewModel.decrement()
            textCounter.text = viewModel.counter.toString()
        }

        btnReset.setOnClickListener {
            viewModel.reset()
            textCounter.text = viewModel.counter.toString()
        }


        Log.d("MainActivity", "onCreate")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

}