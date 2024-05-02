package com.devheverton.lojavirtual.activities.DetalhesProduto

import android.content.Intent
import android.graphics.Color
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.bumptech.glide.Glide

import com.devheverton.lojavirtual.activities.Pagamento.Pagamento
import com.devheverton.lojavirtual.databinding.ActivityDetalhesProdutoBinding
import com.google.android.material.snackbar.Snackbar


class DetalhesProduto : AppCompatActivity() {

    lateinit var binding: ActivityDetalhesProdutoBinding
    var tamnaho_calcado = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foto = intent.extras?.getString("foto")
        val nome = intent.extras?.getString("nome")
        val preco = intent.extras?.getString("preco")

        Glide.with(this).load(foto).into(binding.dtFotoProduto)
        binding.dtNomeDoProduto.text = nome
        binding.dtPrecoProduto.text = "R$ ${preco}"

        binding.btFinalizarPedido.setOnClickListener {

            val tamanho_calcado_38 = binding.tamanho38
            val tamanho_calcado_39 = binding.tamanho39
            val tamanho_calcado_40 = binding.tamanho40
            val tamanho_calcado_41 = binding.tamanho41
            val tamanho_calcado_42 = binding.tamanho42
            val tamanho_calcado_43 = binding.tamanho43

            when (true) {
                tamanho_calcado_38.isChecked -> tamnaho_calcado = "38"
                tamanho_calcado_39.isChecked -> tamnaho_calcado = "39"
                tamanho_calcado_40.isChecked -> tamnaho_calcado = "40"
                tamanho_calcado_41.isChecked -> tamnaho_calcado = "41"
                tamanho_calcado_42.isChecked -> tamnaho_calcado = "42"
                tamanho_calcado_43.isChecked -> tamnaho_calcado = "43"

                else -> {}
            }
            if (!tamanho_calcado_38.isChecked && !tamanho_calcado_39.isChecked && !tamanho_calcado_38.isChecked && !tamanho_calcado_40.isChecked &&
                !tamanho_calcado_41.isChecked && !tamanho_calcado_42.isChecked && !tamanho_calcado_43.isChecked
            ) {
                val snackbar =
                    Snackbar.make(it, "Escolha o tamanho do calçado!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            }else{
                val intent = Intent(this, Pagamento::class.java)
                intent.putExtra("tamanho_calcado", tamnaho_calcado)
                intent.putExtra("nome", nome)
                intent.putExtra("preco",preco)
                startActivity(intent)
            }

        }
    }

}




