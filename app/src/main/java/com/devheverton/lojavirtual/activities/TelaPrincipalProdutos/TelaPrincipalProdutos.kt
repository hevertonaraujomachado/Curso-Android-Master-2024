package com.devheverton.lojavirtual.activities.TelaPrincipalProdutos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager

import com.devheverton.lojavirtual.R
import com.devheverton.lojavirtual.activities.FormLogin.FormLogin
import com.devheverton.lojavirtual.dialog.DialogPerfilUsuario
import com.devheverton.lojavirtual.adapter.AdapterProduto
import com.devheverton.lojavirtual.databinding.ActivityTelaPrincipalProdutosBinding
import com.devheverton.lojavirtual.model.DB
import com.devheverton.lojavirtual.model.Produto
import com.google.firebase.auth.FirebaseAuth

class TelaPrincipalProdutos : AppCompatActivity() {

    lateinit var binding: ActivityTelaPrincipalProdutosBinding
    lateinit var adapterProduto: AdapterProduto
    var lista_produtos: MutableList<Produto> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTelaPrincipalProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_produtos = binding.recyclerProdutos
        recycler_produtos.layoutManager = GridLayoutManager(this, 2)
        recycler_produtos.setHasFixedSize(true)
        adapterProduto = AdapterProduto(this, lista_produtos )
        recycler_produtos.adapter = adapterProduto

        val db = DB()
        db.obterListaDeProdutos(lista_produtos,adapterProduto)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.perfil -> iniciarDialogPerfilUsuario()
            R.id.pedidos-> Log.d("p","Pedidos")
            R.id.sair -> sairUsuario()


        }


        return super.onOptionsItemSelected(item)
    }

    private fun iniciarDialogPerfilUsuario(){
        val dialogPerfilUsuario = DialogPerfilUsuario(this)
        dialogPerfilUsuario.iniciarPerfilUsuario()
        dialogPerfilUsuario.recuperarDadosUsuarioBanco()
    }
    private fun sairUsuario(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }

}