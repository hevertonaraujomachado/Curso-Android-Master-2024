package com.devhevertonaraujo.mvp.Ui.FormCadastro

interface FormCadastroContrato {

    interface View{
        fun MostrarMensagens(texto:String)

    }
        interface Presenter{
            fun Cadastro(email:String,senha:String)

        }
            interface Model{
                fun CadastrarUsuario(email:String,senha:String)

    }
    interface  TaskListener{
        fun Sucesso()
        fun Erro()
        fun VereficarCamposDigitados()
    }
}