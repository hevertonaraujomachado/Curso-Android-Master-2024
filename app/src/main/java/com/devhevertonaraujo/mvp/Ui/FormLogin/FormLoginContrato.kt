package com.devhevertonaraujo.mvp.Ui.FormLogin

interface FormLoginContrato {

    interface View {
        fun MostrarMensagens(texto: String)
        fun IniciarTelaProdutos()
        fun IniciarTelaLogin()
        fun DeixarProgressBarVisivel(visivel: Boolean)


    }
    interface Presenter {
        fun Autenticacao(email: String, senha: String)
        fun VerificarUsuarioLogado()
    }
    interface Model {
        fun AutenticacaoUsuario(email: String, senha: String)

    }
    interface TaskListener{
        fun Sucesso()
        fun Erro()
        fun VereficarCamposDigitados()



    }
}