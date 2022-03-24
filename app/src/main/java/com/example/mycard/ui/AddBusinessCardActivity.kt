
package com.example.mycard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mycard.R
import com.example.mycard.data.Businesscard
import com.example.mycard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by  viewModels {
        MainViewModelFactory((application as App).repository)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener{
            val businessCard = Businesscard(
                nome = binding.twoName.editText?.text.toString(),
                empresa = binding.twoEmpresa.editText?.text. toString(),
                telefone = binding.twoPhone.editText?.text.toString(),
                email = binding.twoEmail.editText?.text.toString(),
                fundoPersonalizado = binding.twCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}