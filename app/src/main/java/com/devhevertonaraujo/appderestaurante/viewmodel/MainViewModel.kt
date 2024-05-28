package com.devhevertonaraujo.appderestaurante.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhevertonaraujo.appderestaurante.model.Produto
import com.devhevertonaraujo.appderestaurante.repositorio.MainRepositorio
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepositorio: MainRepositorio) : ViewModel() {


    private val _listaProdutos = MutableStateFlow<MutableList<Produto>>(mutableListOf())
    private val listaProdutosFlow: StateFlow<MutableList<Produto>> = _listaProdutos

    private val _nomeUsuario = MutableStateFlow<String>("")
    private val nomeUsuarioFlow: StateFlow<String> = _nomeUsuario


    fun getProdutos(): Flow<MutableList<Produto>> {
        viewModelScope.launch {
            mainRepositorio.getProdutos().collect { listaProdutos ->
                _listaProdutos.value = listaProdutos

            }
        }
        return listaProdutosFlow

    }

    fun getdadosPerfilUsuario(): Flow<String> {
        viewModelScope.launch {
            mainRepositorio.dadosPerfilUsuario().collect { nomeUsuario ->
                _nomeUsuario.value = nomeUsuario

            }

        }
        return nomeUsuarioFlow
    }


}