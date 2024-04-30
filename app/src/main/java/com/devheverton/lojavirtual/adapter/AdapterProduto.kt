package com.devheverton.lojavirtual.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devheverton.lojavirtual.databinding.ProdutoItemBinding
import com.devheverton.lojavirtual.model.Produto

class AdapterProduto(val context: Context, val lista_produtos:MutableList<Produto>):
    RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val item_lista = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoViewHolder(item_lista)
    }


    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
     Glide.with(context).load(lista_produtos.get(position).foto).into(holder.fotoProduto)
        holder.nomeProduto.text = lista_produtos.get(position).nome
        holder.precoProduto.text = "R$ ${lista_produtos.get(position).preco}"
    }

    override fun getItemCount() = lista_produtos.size


    inner class ProdutoViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root){
        val fotoProduto = binding.fotoProduto
        val nomeProduto = binding.nomeDoProduto
        val precoProduto = binding.precoDoProduto

    }

}