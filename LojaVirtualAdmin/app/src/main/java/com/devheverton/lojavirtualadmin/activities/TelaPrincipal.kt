package com.devheverton.lojavirtualadmin.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devheverton.lojavirtualadmin.R
import com.devheverton.lojavirtualadmin.databinding.ActivityTelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private var clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.btCadastroProdutos.setOnClickListener {
    val intente = Intent(this,CadastroProdutos::class.java)
    startActivity(intente)
}
        binding.btProdutos.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btProdutos.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btProdutos.setTextColor(Color.WHITE)
                binding.btPedidos.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPedidos.setTextColor(Color.BLACK)
            }
        }
        binding.btPedidos.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btPedidos.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPedidos.setTextColor(Color.WHITE)
                binding.btProdutos.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btProdutos.setTextColor(Color.BLACK)

            }
        }
    }
}