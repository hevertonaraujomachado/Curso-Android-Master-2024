package com.devhevertonaraujo.mvp.Ui.FormCadastro

import com.devhevertonaraujo.mvp.Model.CadastroUsuario

class FormCadastroPresenter(private val view :FormCadastroContrato.View): FormCadastroContrato.Presenter,FormCadastroContrato.TaskListener {

    private val cadastroUsuario: CadastroUsuario = CadastroUsuario(this)

    override fun Cadastro(email: String, senha: String) {
        if (view != null) {
            cadastroUsuario.CadastrarUsuario(email, senha)
        }



    }
    override fun Sucesso() {
        view.MostrarMensagens("Cadastro realizado com sucesso!")
    }

    override fun Erro() {
        view.MostrarMensagens("Erro ao realizar cadastro!")
    }

    override fun VereficarCamposDigitados() {
      view.MostrarMensagens("Preencha todos os campos!")
    }
}