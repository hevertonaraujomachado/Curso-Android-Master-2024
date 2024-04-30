package com.devheverton.lojavirtual.activities.FormLogin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity

import com.devheverton.lojavirtual.activities.FormCadastro.FormCadastro
import com.devheverton.lojavirtual.activities.TelaPrincipalProdutos.TelaPrincipalProdutos
import com.devheverton.lojavirtual.activities.dialog.DialogCarregando
import com.devheverton.lojavirtual.databinding.ActivityFormLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {
     lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val  dialogCarregando = DialogCarregando(this)

        binding.btEntrar.setOnClickListener {view ->
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preecha todos os campos!", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            }else{
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener { tarefa ->
                    if (tarefa.isSuccessful){
                        dialogCarregando.iniciarCarregamentoAlertDialog()
                        Handler(Looper.getMainLooper()).postDelayed({
                            irParaTelaDeProdutos()
                            dialogCarregando.liberarAlertDialog()
                        },3000)

                    }
                }.addOnFailureListener {
                    val snackbar = Snackbar.make(view,"Erro ao fazer o login!",Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.setTextColor(Color.WHITE)
                    snackbar.show()
                }
            }
        }

        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this,FormCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun irParaTelaDeProdutos(){
        val intent = Intent(this,TelaPrincipalProdutos::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            irParaTelaDeProdutos()
        }
    }
}