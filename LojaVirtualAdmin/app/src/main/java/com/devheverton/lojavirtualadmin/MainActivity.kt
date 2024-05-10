package com.devheverton.lojavirtualadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.devheverton.lojavirtualadmin.activities.TelaPrincipal
import com.devheverton.lojavirtualadmin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha =  binding.editSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show()
            }else{
                val intente = Intent(this,TelaPrincipal::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}