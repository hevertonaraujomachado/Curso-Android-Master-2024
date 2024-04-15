package com.devheverton.appdefilmes.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.devheverton.appdefilmes.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editEmail.requestFocus()



        binding.btVamosLa.setOnClickListener {
            val email = binding.editEmail.text.toString()

            if(!email.isEmpty()){
               binding.containerSenha.visibility = View.VISIBLE
                binding.btVamosLa.visibility = View.GONE
                binding.btcontinuar.visibility = View.VISIBLE
                binding.txtTitulo.setText("Um mundo de séries e filmes \n ilimitados espera por você.")
                binding.txtDescricao.setText("Crie uma conta para saber mais sobre \n o nosso App de Filmes")
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff018786")
                binding.containerEmail.helperText = ""
                binding.containerHeader.visibility = View.VISIBLE
            }else{
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")
                binding.containerEmail.helperText = "O email é obrigatorio"
            }

        }
        binding.btcontinuar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (!email.isEmpty() && !senha.isEmpty()){
                Toast.makeText(this,"Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
            }else if (senha.isEmpty()){
                binding.containerEmail.boxStrokeColor = Color.parseColor("FF0000")
                binding.containerSenha.helperText = "A senha é obrigatória."
                binding.containerEmail.boxStrokeColor = Color.parseColor("FF018786")
            }else if(email.isEmpty()){
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")
                binding.containerEmail.helperText = "O email é obrigatorio"
            }
        }

        binding.txtEntrar.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }

    }
}