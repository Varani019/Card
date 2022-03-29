package com.example.mycard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.mycard.App
import com.example.mycard.databinding.ActivityMainBinding
import com.example.mycard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by  viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by  lazy {BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.tvAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivity ::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {card ->
            Image.share(this@MainActivity, card)

        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.gatAll().observe(this) { BusinessCardAdapter ->
            adapter.submitList(BusinessCardAdapter)

        }
    }
}