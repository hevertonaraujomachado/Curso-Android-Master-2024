package com.devheverton.agendadecontatos.adapter

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.devheverton.agendadecontatos.databinding.ContatoItemBinding
import com.devheverton.agendadecontatos.model.Usuario



class ContatoAdpter(private val context: Context, private val listaUsuario: MutableList<Usuario>):
    RecyclerView.Adapter<ContatoAdpter.ContatoViewHolder>() {




     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
         val itemLista = ContatoItemBinding.inflate(LayoutInflater.from(context),parent,false)
         return ContatoViewHolder (itemLista)
     }



     override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.txtNome.text = listaUsuario[position].nome
        holder.txtSobrenome.text = listaUsuario[position].sobrenome
        holder.txtIdade.text = listaUsuario[position].idade
        holder.txtCelular.text = listaUsuario[position].celular

     }
     override fun getItemCount() = listaUsuario.size
inner class ContatoViewHolder(binding: ContatoItemBinding): RecyclerView.ViewHolder(binding.root){

    val txtNome = binding.txtNome
    val txtSobrenome = binding.txtSobrenome
    val txtIdade = binding.txtIdade
    val txtCelular = binding.txtCelular
    val btAtualizar = binding.btAtualizar
    val btDeletar = binding.btDeletar


 }
}
