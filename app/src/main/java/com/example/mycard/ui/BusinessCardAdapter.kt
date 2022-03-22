package com.example.mycard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycard.data.Businesscard
import com.example.mycard.databinding.ItemDoCardBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.coroutines.NonDisposableHandle.parent
import java.lang.invoke.ConstantCallSite

class BusinessCardAdapter :
    ListAdapter<Businesscard, BusinessCardAdapter.ViewHodelder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodelder {
        val inflater = LayoutInflater.from(parent.context)
    }

    override fun onBindViewHolder(holder: ViewHodelder, position: Int) {
    }

    inner class ViewHodelder(
        private val binding: ItemDoCardBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind (item: Businesscard){
            binding.tvNome.text = item.nome
            binding.tvPhone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNameEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
     }
}


 class DiffCallback: DiffUtil.ItemCallback<Businesscard>(){

     override fun areItemsTheSame(oldItem: Businesscard, newItem: Businesscard) = oldItem == newItem

     override fun areContentsTheSame(oldItem: Businesscard, newItem: Businesscard) =
         oldItem.id == newItem.id
 }