package com.devhevertonaraujo.appderestaurante

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.devhevertonaraujo.appderestaurante.databinding.ActivityDetalhesProdutoBinding


class DetalhesProduto : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesProdutoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btVoltarMAin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}