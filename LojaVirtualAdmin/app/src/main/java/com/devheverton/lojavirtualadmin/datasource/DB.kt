package com.devheverton.lojavirtualadmin.datasource

import android.content.Context
import android.net.Uri
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DB {
    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()

    fun cadastroProdutos(
        fotoProduto: Uri,
        nome: String,
        preco: String,
        codigo: String,
        context: Context,
       editNome: EditText,
        editPreco: EditText,
        editCodigo: EditText
    ){
        val StorageReference: StorageReference = storage.getReference("/Produtos/${codigo}")
        StorageReference.putFile(fotoProduto).addOnSuccessListener {
            StorageReference.downloadUrl.addOnSuccessListener{ uri ->

                var produtoMap = hashMapOf(

                    "foto" to uri.toString(),
                    "nome" to nome,
                    "preco" to preco,
                    "codigo" to codigo



                )

                db.collection("Produtos").document(codigo).set(produtoMap).addOnCompleteListener {
                    Toast.makeText(context, "Sucesso ao cadastrar o produto", Toast.LENGTH_SHORT).show()
                    editNome.setText("")
                    editPreco.setText("")
                    editCodigo.setText("")
                }.addOnFailureListener {

                }

            }
        }



    }
}