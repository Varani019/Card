package com.example.mycard

import android.app.Application
import com.example.mycard.data.AppDatabase
import com.example.mycard.data.BusinessCardDao
import com.example.mycard.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.gatDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}