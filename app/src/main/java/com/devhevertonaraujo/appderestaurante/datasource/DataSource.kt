package com.devhevertonaraujo.appderestaurante.datasource

import com.devhevertonaraujo.appderestaurante.model.Produto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DataSource @Inject constructor() {

    private val db = FirebaseFirestore.getInstance()

    private val _listaProdutos = MutableStateFlow<MutableList<Produto>>(mutableListOf())
    private val listaProdutosFlow: StateFlow<MutableList<Produto>> = _listaProdutos

    private val _nomeUsuario = MutableStateFlow<String>("")
    private val nomeUsuarioFlow: StateFlow<String> = _nomeUsuario

    fun getProdutos(): Flow<MutableList<Produto>>{

        val listaProdutos = mutableListOf<Produto>()

        db.collection("Produtos").get().addOnCompleteListener {docummento ->
            if (docummento.isSuccessful){
                for (doc in docummento.result){
                    val produto = doc.toObject(Produto::class.java)
                    listaProdutos.add(produto)
                    _listaProdutos.value = listaProdutos

                }
            }

        }
        return listaProdutosFlow
    }

    fun dadosPerfilUsuario(): Flow<String>{
        db.collection("Usuarios").document("1").addSnapshotListener { value, error ->
            val nomeUsuario = value!!.data!!.get("nome").toString()
            _nomeUsuario.value = nomeUsuario
        }
        return nomeUsuarioFlow
    }
}