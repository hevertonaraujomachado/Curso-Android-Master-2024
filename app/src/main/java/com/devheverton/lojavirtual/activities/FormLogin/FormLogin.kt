package com.devheverton.lojavirtual.activities.FormLogin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devheverton.lojavirtual.R
import com.devheverton.lojavirtual.activities.FormCadastro.FormCadastro
import com.devheverton.lojavirtual.activities.TelaPrincipalProdutos.TelaPrincipalProdutos
import com.devheverton.lojavirtual.databinding.ActivityFormLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {
    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btEntrar.setOnClickListener {view ->
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preecha todos os campos!", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            }else{
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {tarefa ->
                    if (tarefa.isSuccessful){
                        val snackbar = Snackbar.make(view, "Sucesso ao fazer o login!", Snackbar.LENGTH_LONG)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.setTextColor(Color.WHITE)
                        snackbar.show()
                        val intent = Intent(this,TelaPrincipalProdutos::class.java)
                        startActivity(intent)
                        finish()

                    }

                }.addOnFailureListener {
                    val snackbar = Snackbar.make(view, "Erro ao fazer login", Snackbar.LENGTH_LONG)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.setTextColor(Color.WHITE)
                    snackbar.show()

                }
            }

            binding.txtTelaCadastro.setOnClickListener {
                val intent = Intent(this, FormCadastro::class.java)
                startActivity(intent)

            }
        }
    }}