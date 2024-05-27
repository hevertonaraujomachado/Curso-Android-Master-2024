package com.devhevertonaraujo.appderestaurante

import androidx.lifecycle.ViewModel

class MainTest {

    data class Produto(
        val nome: String,
        val descricao: String,
        val preco: String
    )

    data class Usuario(
        val nome: String? = null
    )

    class DataSource{

        fun getProdutos(): MutableList<Produto>{
            val listaProdutos = mutableListOf(
                Produto(
                    nome = "Pizza de Calabresa",
                    descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                    preco = "R$ 45,00"
                ),
                Produto(
                    nome = "Pizza de Queijo",
                    descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                    preco = "R$ 80,00"
                ),
                Produto(
                    nome = "Pizza Portuguesa",
                    descricao = "dsfsdfsdfsdfdsfdsfdsdfd",
                    preco = "R$ 60,00"
                )
            )
            return listaProdutos
        }

        fun dadosPerfilUsuario(): String? {
            val nomeUsuario = Usuario("Jonh Cena")
            return nomeUsuario.nome
        }
    }

    class MainRepositorio(){
        val dataSource = DataSource()

        fun getProdutos(): MutableList<Produto>{
            return dataSource.getProdutos()
        }

        fun dadosPerfilUsuario(): String? {
            return dataSource.dadosPerfilUsuario()
        }
    }

    class MainViewModel(private val mainRepositorio: MainRepositorio): ViewModel(){

        fun getProdutos(): MutableList<Produto>{
            return mainRepositorio.getProdutos()
        }

        fun dadosPerfilUsuario(): String? {
            return mainRepositorio.dadosPerfilUsuario()
        }
    }

}