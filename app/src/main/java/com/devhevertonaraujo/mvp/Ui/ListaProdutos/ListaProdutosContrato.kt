package com.devhevertonaraujo.mvp.Ui.ListaProdutos

import com.devhevertonaraujo.mvp.Model.Produto

interface ListaProdutosContrato {

    interface View {
        fun AddProdutos(produtos: MutableList<Produto>)

    }
    interface Presenter {
        fun MostrarListaProdutos()


    }
}