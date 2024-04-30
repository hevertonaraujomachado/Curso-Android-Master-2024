package com.devheverton.lojavirtual.model

import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class DB {
    fun salvarDadosUsuarios(nome: String){

        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseFirestore.getInstance()

        val usuarios = hashMapOf(
            "nome" to nome
        )

        val documentReference: DocumentReference = db.collection("Usuarios").document(usuarioID)
        documentReference.set(usuarios).addOnSuccessListener {
            Log.d("DB", "Sucesso ao salvar os dados")
        }.addOnFailureListener { erro ->
            Log.d("DB_ERROR", "Erro ao salvar os dados! ${erro.printStackTrace()}")
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
}