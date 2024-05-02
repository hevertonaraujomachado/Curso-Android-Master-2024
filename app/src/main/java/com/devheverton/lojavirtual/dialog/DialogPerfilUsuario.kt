package com.devheverton.lojavirtual.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import com.devheverton.lojavirtual.activities.FormLogin.FormLogin
import com.devheverton.lojavirtual.databinding.DialogPerfilUsuarioBinding
import com.devheverton.lojavirtual.model.DB
import com.google.firebase.auth.FirebaseAuth

class DialogPerfilUsuario(private val activity: Activity) {

    lateinit var dialog: AlertDialog
    lateinit var binding: DialogPerfilUsuarioBinding

    fun iniciarPerfilUsuario(){
        val builder = AlertDialog.Builder(activity)
        binding = DialogPerfilUsuarioBinding.inflate(activity.layoutInflater)
        builder.setView(binding.root)
        builder.setCancelable(true)
        dialog = builder.create()
        dialog.show()


    }
    fun recuperarDadosUsuarioBanco(){
        val nomeUsuario = binding.txtNomeUsuario
        val emailUsuario = binding.txtEmailUsuario
        val db = DB()
        db.recuparaDadosUsuarioPerfil(nomeUsuario,emailUsuario)

        binding.btDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity,FormLogin::class.java)
            activity.startActivity(intent)
            activity.finish()
        }

    }
}