package com.devheverton.lojavirtual.activities.Pedidos



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devheverton.lojavirtual.adapter.AdapterPedido
import com.devheverton.lojavirtual.databinding.ActivityPedidosBinding
import com.devheverton.lojavirtual.model.DB
import com.devheverton.lojavirtual.model.Pedido


class Pedidos : AppCompatActivity() {
    lateinit var binding: ActivityPedidosBinding
    lateinit var adapterPedidos: AdapterPedido
    var lista_pedidos: MutableList<Pedido> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_pedidos = binding.recylclerPedidos
        recycler_pedidos.layoutManager = LinearLayoutManager(this)
        recycler_pedidos.setHasFixedSize(true)
        adapterPedidos = AdapterPedido(this,lista_pedidos)
        recycler_pedidos.adapter = adapterPedidos

        val db = DB()
        db.obterListaDePedidos(lista_pedidos,adapterPedidos)

}
}
