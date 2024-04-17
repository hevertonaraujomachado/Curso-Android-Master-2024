package com.devheverton.agendadecontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import com.devheverton.agendadecontatos.model.Usuario

@Dao
interface UsuarioDao {
    @Insert
    fun inserir(listaUsuarios: MutableList<Usuario>)
}