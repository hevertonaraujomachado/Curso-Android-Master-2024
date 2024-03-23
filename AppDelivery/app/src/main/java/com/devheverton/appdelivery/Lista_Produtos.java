package com.devheverton.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devheverton.appdelivery.Adapter.AdapterProduto;
import com.devheverton.appdelivery.Model.Produto;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Lista_Produtos extends AppCompatActivity {

    private RecyclerView recyclerView_produtos;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

recyclerView_produtos = findViewById(R.id.recycleView_produtos);
produtoList = new ArrayList<>();
adapterProduto = new AdapterProduto(getApplicationContext(),produtoList);
recyclerView_produtos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
recyclerView_produtos.setHasFixedSize(true);
recyclerView_produtos.setAdapter(adapterProduto);

Produto produto = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
produtoList.add(produto);

        Produto produto2 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto2);

        Produto produto3 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto);

        Produto produto4 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto4);

        Produto produto5 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto5);

        Produto produto6 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto6);

        Produto produto7 = new Produto(R.drawable.ic_launcher_background,  "Produto 1", "R$ 50,00");
        produtoList.add(produto7);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.perfil){
            Intent intent = new Intent(Lista_Produtos.this,Perfil_Usuario.class);
            startActivity(intent);
            
        } else if (itemID == R.id.pedidos) {
            
        } else if (itemID == R.id.deslogar) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(Lista_Produtos.this, "Usuário Deslogado" ,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Lista_Produtos.this,Form_Login.class);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}