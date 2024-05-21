package com.devhevertonaraujo.mvp.Ui.FormLogin

import com.devhevertonaraujo.mvp.Model.AutenticacaoUsuario
import com.google.firebase.auth.FirebaseAuth

class FormLoginPresenter(private val view: FormLoginContrato.View): FormLoginContrato.Presenter,FormLoginContrato.TaskListener {

    private val  autenticacaoUsuario: AutenticacaoUsuario = AutenticacaoUsuario(this)
    override fun Autenticacao(email: String, senha: String) {
        if (view != null){
            autenticacaoUsuario.AutenticacaoUsuario(email,senha)
        }
    }

    override fun VerificarUsuarioLogado() {
        val usuarioAtual = FirebaseAuth.getInstance().currentUser
        if (usuarioAtual != null){
            view.IniciarTelaProdutos()
        }

    }

    override fun Sucesso() {
        view.MostrarMensagens("Login realizado com sucesso")
        view.DeixarProgressBarVisivel(true)
        view.IniciarTelaLogin()

    }

    override fun Erro() {
        view.MostrarMensagens("Erro ao realizar login do usuário")
    }

    override fun VereficarCamposDigitados() {
        view.MostrarMensagens("Preecha todos os campos!")
    }


}

