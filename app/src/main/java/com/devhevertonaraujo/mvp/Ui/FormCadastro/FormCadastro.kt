package com.devhevertonaraujo.mvp.Ui.FormCadastro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devhevertonaraujo.mvp.R
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity(), FormCadastroContrato.View {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btCadastrar: Button

    private lateinit var presenter: FormCadastroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        presenter = FormCadastroPresenter(this)

        supportActionBar!!.hide()
        IniciarComponentes()

        btCadastrar.setOnClickListener {

            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            presenter.Cadastro(email, senha)


        }
    }

    fun IniciarComponentes(){
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        btCadastrar = findViewById(R.id.bt_cadastrar)
    }

    fun CadastrarUsuario() {

        var email = editEmail.text.toString()
        var senha = editSenha.text.toString()
    }

    override fun MostrarMensagens(texto: String) {
Toast.makeText(this, texto, Toast.LENGTH_LONG).show()
    }

}

