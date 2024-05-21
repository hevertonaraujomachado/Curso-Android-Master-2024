package com.devhevertonaraujo.mvp.Ui.FormLogin


import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devhevertonaraujo.mvp.Ui.ListaProdutos.ListaProdutos
import com.devhevertonaraujo.mvp.R
import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastro
import com.google.firebase.auth.FirebaseAuth
import java.util.logging.Handler

class FormLogin : AppCompatActivity(), FormLoginContrato.View {

    private lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btEntrar: Button
    lateinit var progressbar: ProgressBar
    lateinit var text_tela_cadastro: TextView

    private lateinit var preseter: FormLoginContrato.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        preseter = FormLoginPresenter(this)
        preseter.VerificarUsuarioLogado()

        supportActionBar!!.hide()
        IniciarComponentes()



        btEntrar.setOnClickListener {

            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()
            preseter.Autenticacao(email, senha)



        }

        text_tela_cadastro.setOnClickListener {
            IniciarTelaLogin()

        }

    }

    fun IniciarComponentes() {
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        btEntrar = findViewById(R.id.bt_entrar)
        progressbar = findViewById(R.id.progressBar_login)
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro)
    }





    override fun MostrarMensagens(texto: String) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()


    }

    override fun IniciarTelaProdutos() {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, ListaProdutos::class.java)
        startActivity(intent)
        finish()



        },3000)

    }


    override fun IniciarTelaLogin() {
        val intent = Intent(this, FormCadastro::class.java)
        startActivity(intent)



    }

    override fun DeixarProgressBarVisivel(visivel: Boolean) {
        progressbar.visibility = View.VISIBLE

    }


}