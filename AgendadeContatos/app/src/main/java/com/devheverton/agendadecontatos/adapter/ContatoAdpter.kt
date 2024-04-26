package com.devheverton.agendadecontatos.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devheverton.agendadecontatos.AppDatabase
import com.devheverton.agendadecontatos.Atualizar
import com.devheverton.agendadecontatos.dao.UsuarioDao


import com.devheverton.agendadecontatos.databinding.ContatoItemBinding
import com.devheverton.agendadecontatos.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ContatoAdpter(private val context: Context, private val listaUsuario: MutableList<Usuario>):
    RecyclerView.Adapter<ContatoAdpter.ContatoViewHolder>() {




     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
         val itemLista = ContatoItemBinding.inflate(LayoutInflater.from(context),parent,false)
         return ContatoViewHolder (itemLista)
     }



     @SuppressLint("NotifyDataSetChanged")
     override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.txtNome.text = listaUsuario[position].nome
        holder.txtSobrenome.text = listaUsuario[position].sobrenome
        holder.txtIdade.text = listaUsuario[position].idade
        holder.txtCelular.text = listaUsuario[position].celular

         holder.btAtualizar.setOnClickListener {
             val intent = Intent(context,Atualizar::class.java)
             intent.putExtra("nome",listaUsuario[position].nome)
             intent.putExtra("sobrenome",listaUsuario[position].sobrenome)
             intent.putExtra("idade",listaUsuario[position].idade)
             intent.putExtra("celular",listaUsuario[position].celular)
             intent.putExtra("uid",listaUsuario[position].uid)
             context.startActivity(intent)


         }
         holder.btDeletar.setOnClickListener {
             CoroutineScope(Dispatchers.IO).launch {
                 val usuario = listaUsuario[position]
                 val usuarioDao: UsuarioDao = AppDatabase.getInstance(context).usuarioDao()
                 usuarioDao.deletar(usuario.uid)
                 listaUsuario.remove(usuario)

                 withContext(Dispatchers.Main){
                     notifyDataSetChanged()
                 }

             }
         }


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
