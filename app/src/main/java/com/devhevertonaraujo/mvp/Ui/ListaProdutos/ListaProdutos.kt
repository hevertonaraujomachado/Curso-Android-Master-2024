package com.devhevertonaraujo.mvp.Ui.ListaProdutos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devhevertonaraujo.mvp.Adapter.AdapterProduto
import com.devhevertonaraujo.mvp.Model.AddProdutos
import com.devhevertonaraujo.mvp.Model.Produto
import com.devhevertonaraujo.mvp.R

class ListaProdutos : AppCompatActivity(), ListaProdutosContrato.View {

    private lateinit var presenter: ListaProdutosPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        presenter = ListaProdutosPresenter(this,AddProdutos())
        presenter.MostrarListaProdutos()


        }

    override fun AddProdutos(produtos: MutableList<Produto>) {

        val recycler_produtos = findViewById<RecyclerView>(R.id.recycler_produtos);
        recycler_produtos.layoutManager = LinearLayoutManager(this)
        recycler_produtos.adapter = AdapterProduto(AddProdutos(),this)

    }

}