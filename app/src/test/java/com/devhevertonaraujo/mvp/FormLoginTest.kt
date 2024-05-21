package com.devhevertonaraujo.mvp

import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastroContrato
import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastroPresenter
import com.devhevertonaraujo.mvp.Ui.FormLogin.FormLoginContrato
import com.devhevertonaraujo.mvp.Ui.FormLogin.FormLoginPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.text.Normalizer.Form

class FormLoginTest {

    @Mock
    lateinit var formLoginView: FormLoginContrato.View

    @Mock
    lateinit var  formLoginPresenter: FormLoginContrato.Presenter

    @Mock
    lateinit var  usuarioAutenticacao: FormLoginContrato.Model

    @Before
    fun setupLogin() {
        MockitoAnnotations.openMocks(this)
        formLoginPresenter = FormLoginPresenter(formLoginView)

    }
    @Mock
    lateinit var formCadastroViem: FormCadastroContrato.View

    lateinit var formCadastroPresenter: FormCadastroContrato.Presenter

    @Before
    fun setupCadastro() {
        MockitoAnnotations.openMocks(this)
        formCadastroPresenter = FormCadastroPresenter(formCadastroViem)
    }

    @Test
fun `test vereficar a mensagem do toast`(){
    formLoginView.MostrarMensagens("Preencha todos os campos!")
        Mockito.verify(formLoginView).MostrarMensagens("Preencha todos os campos!")

}
    @Test
    fun `test vereficar se realmente a progressBar vai ficar visivel`(){
       val visible = true
        val invisible = false
        formLoginView.DeixarProgressBarVisivel(visible)
        Mockito.verify(formLoginView).DeixarProgressBarVisivel(visible)


    }
    @Test
    fun `test vereficar todo o processo de autenticação de usuário`(){
        val email = "hevertonaraujomachado@gmail.com"
        val senha = "123456"

        val inputEmail = "hevertonaraujomachado@gmail.com"
        val inputSenha = "123456"

        usuarioAutenticacao.AutenticacaoUsuario(inputEmail,inputSenha)

        if (inputEmail.isEmpty() || inputSenha.isEmpty()){
            println("Preencha todos os campos!")
        }else if (inputEmail == email && inputSenha == senha){
            println("Login efetuado com sucesso!")
        }else{
            println("Erro ao fazer o login do usuário!")
        }
        Mockito.verify(usuarioAutenticacao).AutenticacaoUsuario(email,senha)

}
}