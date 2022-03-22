package com.example.mycard.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mycard.data.BusinessCardRepository
import com.example.mycard.data.Businesscard

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businesscard: Businesscard){
        businessCardRepository.insert(businesscard)
    }

    fun gatAll() : LiveData<List<Businesscard>>{
        return businessCardRepository.garAll()
    }
}

 class MainViewModelFactory(private val repository: BusinessCardRepository):
     ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) :T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
         }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}