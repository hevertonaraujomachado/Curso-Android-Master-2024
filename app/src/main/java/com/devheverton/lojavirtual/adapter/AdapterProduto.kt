package com.devheverton.lojavirtual.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devheverton.lojavirtual.databinding.ProdutoItemBinding
import com.devheverton.lojavirtual.model.Produto

class AdapterProduto(val context: Context, val lista_produto:MutableList<Produto>):
    RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val item_lista = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoViewHolder(item_lista)
    }


    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
       lista_produto.get(position).foto?.let { holder.fotoProduto.setImageResource(it) }
        holder.nomeProduto.text = lista_produto.get(position).nome
        holder.precoProduto.text = lista_produto.get(position).preco
    }

    override fun getItemCount() = lista_produto.size


    inner class ProdutoViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root){
        val fotoProduto = binding.fotoProduto
        val nomeProduto = binding.nomeDoProduto
        val precoProduto = binding.precoDoProduto

    }

}