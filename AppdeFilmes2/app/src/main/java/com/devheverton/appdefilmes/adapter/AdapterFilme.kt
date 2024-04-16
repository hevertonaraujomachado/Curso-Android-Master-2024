package com.devheverton.appdefilmes.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devheverton.appdefilmes.databinding.FilmeItemBinding

import com.devheverton.appdefilmes.model.Filme
import com.devheverton.appdefilmes.view.DetalhesFilme

class AdapterFilme (private val context: Context, private val listaFilme: MutableList<Filme>):
    RecyclerView.Adapter<AdapterFilme.FilmeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemLista = FilmeItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return FilmeViewHolder(itemLista)
    }


    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        Glide.with(context).load(listaFilme[position].capa).centerCrop().into(holder.capa)

        holder.capa.setOnClickListener {
            val intent = Intent(context,DetalhesFilme:: class.java)
            context.startActivity(intent)

        }
    }
    override fun getItemCount() = listaFilme.size


    inner class FilmeViewHolder(binding: FilmeItemBinding): RecyclerView.ViewHolder(binding.root){
        val capa = binding.CapaFilme

    }

}