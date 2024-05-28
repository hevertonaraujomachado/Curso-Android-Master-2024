package com.devhevertonaraujo.appderestaurante

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.devhevertonaraujo.appderestaurante.adpter.ProdutoAdapter
import com.devhevertonaraujo.appderestaurante.databinding.ActivityMainBinding
import com.devhevertonaraujo.appderestaurante.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var produtoAdapter: ProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()


        lifecycleScope.launch {
            mainViewModel.getdadosPerfilUsuario().collect { nomeUser ->
                binding.txtNomeUsuario.text = nomeUser

            }


        }
        lifecycleScope.launch {
            mainViewModel.getProdutos().collect { listaProdutos ->
                val recyclerViewProdutos = binding.recyclerViewProdutos
                recyclerViewProdutos.layoutManager = LinearLayoutManager(this@MainActivity)
                produtoAdapter = ProdutoAdapter(this@MainActivity, listaProdutos)
                recyclerViewProdutos.setHasFixedSize(true)
                recyclerViewProdutos.adapter = produtoAdapter
                produtoAdapter.notifyDataSetChanged()

            }
        }
    }
}
