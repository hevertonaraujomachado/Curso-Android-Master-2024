package com.devhevertonaraujo.appderestaurante

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainRepositoryTest {

    private lateinit var  mainRepositoryTest: MainTest.MainRepositorio


    @Before
    fun setupMain(){
        mainRepositoryTest = MainTest.MainRepositorio()
    }
    @Test
    fun `test vereficando o nome do usuario que está chegando no perfil`(){
        val nomeUsuario = mainRepositoryTest.dadosPerfilUsuario()
        Assert.assertEquals("Jonh Cena", nomeUsuario)
    }
}