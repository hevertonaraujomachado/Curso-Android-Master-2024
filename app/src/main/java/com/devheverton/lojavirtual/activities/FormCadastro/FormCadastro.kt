package com.devheverton.lojavirtual.activities.FormCadastro

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devheverton.lojavirtual.databinding.ActivityFormCadastroBinding
import com.devheverton.lojavirtual.model.DB
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        val db = DB()


        binding.btCadastrar.setOnClickListener {

            val nome = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(it, "Preecha todos os campos!", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { tarefa ->
                        if (tarefa.isSuccessful) {
                            db.salvarDadosUsuarios(nome)
                            val snackbar = Snackbar.make(
                                it,
                                "Cadastro realizado com sucesso!",
                                Snackbar.LENGTH_LONG
                            )
                            snackbar.setBackgroundTint(Color.BLUE)
                            snackbar.setTextColor(Color.WHITE)
                            snackbar.show()
                        }

                    }.addOnFailureListener { erroCadastro ->
                        val menssagemErro = when(erroCadastro){
                            is FirebaseAuthWeakPasswordException -> "Digite uma senha no mínimo 6 caracteres"
                            is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada"
                            is FirebaseNetworkException -> "Sem conexão com a internet"
                            else -> "Erro ao cadastrar usuário"

                        }
                        val snackbar = Snackbar.make(
                            it, menssagemErro, Snackbar.LENGTH_LONG)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.setTextColor(Color.WHITE)
                        snackbar.show()


                    }
            }
        }
    }
}