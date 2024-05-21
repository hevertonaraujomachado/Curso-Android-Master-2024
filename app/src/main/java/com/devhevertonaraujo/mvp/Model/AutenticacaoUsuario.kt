package com.devhevertonaraujo.mvp.Model

import android.annotation.SuppressLint
import com.devhevertonaraujo.mvp.Ui.FormLogin.FormLoginContrato
import com.google.firebase.auth.FirebaseAuth

class AutenticacaoUsuario(private val taskListener: FormLoginContrato.TaskListener):FormLoginContrato.Model {

    @SuppressLint("NotConstructor")
    override fun AutenticacaoUsuario(email: String, senha: String) {
       if (email.isEmpty() || senha.isEmpty()){
           taskListener.VereficarCamposDigitados()


       } else {
           FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
               if (autenticacao.isSuccessful){
                   taskListener.Sucesso()


                   }

               }.addOnFailureListener {
                   taskListener.Erro()

           }
       }
    }
       }

