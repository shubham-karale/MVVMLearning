package com.example.mvvmlearning

import androidx.lifecycle.ViewModel

class MainViewModel(val initialValue:Int):ViewModel() {

    var counter = initialValue;

    fun increment(){
        counter++;

    }

    fun decrement(){
        counter--;
    }

    fun reset(){
        counter = 0;
    }


}