package com.devheverton.lojavirtualadmin.activities

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devheverton.lojavirtualadmin.R
import com.devheverton.lojavirtualadmin.databinding.ActivityCadastroProdutosBinding
import com.devheverton.lojavirtualadmin.datasource.DB

class CadastroProdutos : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroProdutosBinding
    private var fotoProdutos: Uri? = null
    private var db = DB()



    private val selecionarFotoGaleria =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                fotoProdutos = uri
                binding.imgProduto.setImageURI(fotoProdutos)
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btSelecionarFotoProduto.setOnClickListener {
            selecionarFotoGaleria.launch("image/*")
        }
        binding.btcadastrar.setOnClickListener {
            val nome : String = binding.editNomeProduto.text.toString()
            val preco: String = binding.editPrecoProduto.text.toString()
            val codigo: String = binding.editCodigoProduto.text.toString()

            if(nome.isEmpty() || preco.isEmpty() || codigo.isEmpty()){
                Toast.makeText(this,"Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }else{
                db.cadastroProdutos(fotoProdutos!!, nome,preco,codigo,this,
                    binding.editNomeProduto,
                    binding.editPrecoProduto,
                    binding.editCodigoProduto)
            }

        }
    }

}