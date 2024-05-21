package com.devhevertonaraujo.mvp.Model

import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastroContrato
import com.google.firebase.auth.FirebaseAuth

class CadastroUsuario(private val taskListener: FormCadastroContrato.TaskListener): FormCadastroContrato.Model {
    override fun CadastrarUsuario(email: String, senha: String) {
        if (email.isEmpty() || senha.isEmpty()) {
            taskListener.VereficarCamposDigitados()

        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
                        taskListener.Sucesso()


                    }
                }.addOnFailureListener {
                    taskListener.Erro()
                }
        }
    }
}

