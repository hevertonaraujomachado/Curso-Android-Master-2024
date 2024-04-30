package com.devheverton.lojavirtual.activities.dialog

import android.app.Activity
import android.app.AlertDialog
import com.devheverton.lojavirtual.databinding.DialogPerfilUsuarioBinding

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
}