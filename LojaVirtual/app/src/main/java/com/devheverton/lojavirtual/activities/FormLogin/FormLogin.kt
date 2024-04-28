package com.devheverton.lojavirtual.activities.FormLogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devheverton.lojavirtual.R
import com.devheverton.lojavirtual.activities.FormCadastro.FormCadastro
import com.devheverton.lojavirtual.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {
    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

binding.txtTelaCadastro.setOnClickListener {
    val intent = Intent(this,FormCadastro::class.java)
    startActivity(intent)

}
    }
}