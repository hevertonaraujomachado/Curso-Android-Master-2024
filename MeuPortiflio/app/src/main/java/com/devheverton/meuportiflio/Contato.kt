package com.devheverton.meuportiflio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devheverton.meuportiflio.databinding.ActivityContatoBinding
import com.devheverton.meuportiflio.databinding.ActivityMainBinding

class Contato : AppCompatActivity() {

    private lateinit var binding: ActivityContatoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toobarContato = binding.toobarContato
        toobarContato.setNavigationOnClickListener {
           finish()
        }
        binding.btWhatsApp.setOnClickListener {
            abrirWhatsApp()

        }

        }
    private fun abrirWhatsApp(){

        val numeroTelefone = "5589994163840"
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$numeroTelefone")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

        if (numeroTelefone.equals(numeroTelefone)){
            startActivity(intent)
        }else{
            val playStoreIntent = Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"))
            startActivity(playStoreIntent)
        }


    }
    }
