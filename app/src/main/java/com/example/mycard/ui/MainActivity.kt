package com.example.mycard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.mycard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by  viewModels {
        MainViewModelFactory((application as App).repository)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.tvAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivity ::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.gatAll().observe(this,{  })
    }
}