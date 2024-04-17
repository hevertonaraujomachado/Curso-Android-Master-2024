package com.devheverton.appdefilmes.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.devheverton.appdefilmes.databinding.ActivityDetalhesFilmeBinding

class DetalhesFilme : AppCompatActivity() {

    private  lateinit var binding: ActivityDetalhesFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val capa =intent.extras?.getString("capa")
        val nome =intent.extras?.getString("nome")
        val descricao =intent.extras?.getString("descricao")
        val elenco =intent.extras?.getString("elenco")

        Glide.with(this).load(capa).centerCrop().into(binding.capaFilme)
        binding.txtNomeFilme.setText(nome)
        binding.txtDescricao.setText("Descricão: $descricao")
        binding.txtElenco.setText("Elenco: $elenco")


    }
}