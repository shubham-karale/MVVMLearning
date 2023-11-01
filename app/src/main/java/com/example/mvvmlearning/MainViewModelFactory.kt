package com.example.mvvmlearning

import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(val counter:Int): ViewModelProvider.Factory {

    fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(counter) as T
    }

}