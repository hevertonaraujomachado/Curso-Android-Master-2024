package com.devhevertonaraujo.mvp

import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastroContrato
import com.devhevertonaraujo.mvp.Ui.FormCadastro.FormCadastroPresenter

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FormLoginTestCdastroTest {

@Mock
    lateinit var formCadastroViem: FormCadastroContrato.View

    @Mock
    lateinit var  formCadastroPresenter: FormCadastroContrato.Presenter

    lateinit var usuarioCadastro: FormCadastroContrato.Model

    @Before
    fun setupCadastro(){
        MockitoAnnotations.openMocks(this)
        formCadastroPresenter = FormCadastroPresenter(formCadastroViem)
    }
    @Test
    fun `teste vereficar a mensagem do toast`(){
        formCadastroViem.MostrarMensagens("Preecha todos os campos...")
        Mockito.verify(formCadastroViem).MostrarMensagens("Preecha todos os campos...")
    }
    @Test
    fun `teste vereficar todo o processo de cadastro de usuário`(){
        val email = "hevertonaraujomachado@gmail.com"
        val senha = "123456"

        val inputEmail = "hevertonaraujomachado@gmail.com"
        val inputSenha = "123456"

        usuarioCadastro.CadastrarUsuario(inputEmail,inputSenha)

        if (inputEmail.isEmpty() || inputSenha.isEmpty()){
            println("Preecha todos os campos...")
        }else if (email == inputEmail && senha == inputSenha){
            println("Cadastro realizado com sucesso!")


        }else{
            println("Erro ao cadastrar usuário")
        }
        Mockito.verify(usuarioCadastro).CadastrarUsuario(email,senha)
    }
}