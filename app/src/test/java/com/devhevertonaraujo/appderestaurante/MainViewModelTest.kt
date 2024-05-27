package com.devhevertonaraujo.appderestaurante

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainViewModelTest {


    private lateinit var mainViewModel: MainTest.MainViewModel
    private lateinit var mainRepositorio: MainTest.MainRepositorio

    @Before
    fun setupMain() {
        mainRepositorio = MainTest.MainRepositorio()
        mainViewModel = MainTest.MainViewModel(mainRepositorio)
    }

    @Test
    fun `test o nome do usuário precisa chegar valores do tipo nulo - o test precisa falhar`() {
        val nomeUsuario = mainViewModel.dadosPerfilUsuario()
        Assert.assertEquals(nomeUsuario, null)
    }

    @Test
    fun `test vereficar o nome do usuário`() {
        val nomeUsuario = mainViewModel.dadosPerfilUsuario()
        Assert.assertEquals("Jonh Cena", nomeUsuario)
    }

    @Test
    fun `test  vereficar a quantidade de itens que tem na lista de produtos`() {
        val tamanhoEsperado = 3
        val listaProdutos = mainViewModel.getProdutos()
        Assert.assertEquals(tamanhoEsperado, listaProdutos.size)
    }

    @Test
    fun `test vereficar o nome dotodos os produto da lista estão ok`() {


        val listaProdutos = mainViewModel.getProdutos()

        val listaProdutosEsperados = mutableListOf(
            MainTest.Produto(
                nome = "Pizza de Calabresa",
                descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                preco = "R$ 45,00"
            ),
            MainTest.Produto(
                nome = "Pizza de Queijo",
                descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                preco = "R$ 80,00"
            ),
            MainTest.Produto(
                nome = "Pizza Portuguesa",
                descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                preco = "R$ 60,00"

            )
        )
        Assert.assertEquals(listaProdutosEsperados, listaProdutos)
    }


}