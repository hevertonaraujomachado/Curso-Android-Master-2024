package com.devhevertonaraujo.mvp.Ui.ListaProdutos

import com.devhevertonaraujo.mvp.Model.Produto


class ListaProdutosPresenter(private val view: ListaProdutosContrato.View, private val produtos: MutableList<Produto>): ListaProdutosContrato.Presenter{
    override fun MostrarListaProdutos() {
        val listaProdutos = produtos
        view.AddProdutos(listaProdutos)

    }


}