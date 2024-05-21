package com.devhevertonaraujo.mvp.Model

class Produto (
    val nome: String,
    val preco: String,
    val descricao: String
)

class ProdutoBuilder{
    var nome: String = ""
    var preco: String = ""
    var descricao: String = ""
    fun build(): Produto = Produto(nome,preco,descricao)
}

fun produtos(block: ProdutoBuilder.() -> Unit): Produto = ProdutoBuilder().apply(block).build()

fun AddProdutos(): MutableList<Produto> = mutableListOf(
    produtos {
        nome = "Placa de Vídeo"
        preco = "R$ 500,00"
        descricao = "gfdgdfgdfgdfg"
    },
    produtos {
        nome = "Processador Intel"
        preco = "R$ 850,99"
        descricao = "fdfgrfgfgfgfgfgfggfgfgfgfgfgfgfgf"
    }
)

