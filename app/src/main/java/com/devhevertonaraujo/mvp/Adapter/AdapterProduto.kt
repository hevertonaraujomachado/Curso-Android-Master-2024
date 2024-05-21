package com.devhevertonaraujo.mvp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devhevertonaraujo.mvp.Model.Produto
import com.devhevertonaraujo.mvp.R


class AdapterProduto (val produtos: MutableList<Produto>, val context: Context): RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.produto_item,parent,false)
        val holder = ProdutoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.nome.text = produtos[position].nome
        holder.preco.text = produtos[position].preco
        holder.descricao.text = produtos[position].descricao
    }

    override fun getItemCount(): Int = produtos.size


    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nome = itemView.findViewById<TextView>(R.id.nomeProduto)
        val preco = itemView.findViewById<TextView>(R.id.precoProduto)
        val descricao = itemView.findViewById<TextView>(R.id.descricaoProduto)

    }
}



