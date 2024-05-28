package com.devhevertonaraujo.appderestaurante.repositorio

import com.devhevertonaraujo.appderestaurante.datasource.DataSource
import com.devhevertonaraujo.appderestaurante.model.Produto
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class MainRepositorio @Inject constructor() {

    val dataSouce = DataSource()

    fun getProdutos(): Flow<MutableList<Produto>>{
        return dataSouce.getProdutos()
    }
    fun dadosPerfilUsuario(): Flow<String>{
        return dataSouce.dadosPerfilUsuario()
    }
}