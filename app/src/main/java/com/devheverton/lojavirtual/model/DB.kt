package com.devheverton.lojavirtual.model

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import com.devheverton.lojavirtual.adapter.AdapterProduto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class DB {
    fun salvarDadosUsuarios(nome: String){

        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseFirestore.getInstance()

        val usuarios = hashMapOf(
            "nome" to nome
        )

        val documentReference: DocumentReference = db.collection("Usuarios").document(usuarioID)
        documentReference.set(usuarios).addOnSuccessListener {
            Log.d("DB","Sucesso ao salvar os dados!")
        }.addOnFailureListener { erro ->
            Log.d("DB_ERROR","Erro ao salvar os dados! ${erro.printStackTrace()}")
        }
    }

    fun recuparaDadosUsuarioPerfil(nomeUsuario: TextView, emailUsuario: TextView){
        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val email = FirebaseAuth.getInstance().currentUser!!.email
        val db = FirebaseFirestore.getInstance()

        val documentReference : DocumentReference = db.collection("Usuarios").document(usuarioID)
        documentReference.addSnapshotListener { documento, error ->
            if (documento != null){
                nomeUsuario.text = documento.getString("nome")
                emailUsuario.text = email
            }
        }

    }
    @SuppressLint("NotifyDataSetChanged")
    fun obterListaDeProdutos(lista_produtos: MutableList<Produto>, adapter_produto: AdapterProduto){

        val db = FirebaseFirestore.getInstance()

        db.collection("Produtos").get()
            .addOnCompleteListener { tarefa ->
                if (tarefa.isSuccessful){
                    for (documento in tarefa.result!!){
                        val produtos = documento.toObject(Produto::class.java)
                        lista_produtos.add(produtos)
                        adapter_produto.notifyDataSetChanged()
                }
            }
        }
    }
}