package com.devheverton.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devheverton.appdelivery.Adapter.AdapterProduto;
import com.devheverton.appdelivery.Model.Produto;
import com.devheverton.appdelivery.RecycleViewItemClickListener.RecyclerViewItemClickListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Lista_Produtos extends AppCompatActivity {
    private RecyclerView recyclerView_produtos;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList;
    private FirebaseFirestore db;

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

        //Evento de click no RecyclerView
        recyclerView_produtos.addOnItemTouchListener(
                new RecyclerViewItemClickListener(
                        getApplicationContext(),
                        recyclerView_produtos,
                        new RecyclerViewItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Intent intent = new Intent(Lista_Produtos.this,Detalhes_Produto.class);
                                intent.putExtra("foto",produtoList.get(position).getFoto());
                                intent.putExtra("nome",produtoList.get(position).getNome());
                                intent.putExtra("descricao",produtoList.get(position).getDescricao());
                                intent.putExtra("preco",produtoList.get(position).getPreco());
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        db = FirebaseFirestore.getInstance();

        db.collection("Produtos").orderBy("nome")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull  Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                                Produto produto = queryDocumentSnapshot.toObject(Produto.class);
                                produtoList.add(produto);
                                adapterProduto.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemID = item.getItemId();

        if (itemID == R.id.perfil){
            Intent intent = new Intent(Lista_Produtos.this,Perfil_Usuario.class);
            startActivity(intent);
        }else if (itemID == R.id.pedidos){

        }else if (itemID == R.id.deslogar){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(Lista_Produtos.this,"Usuário Deslogado!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Lista_Produtos.this,Form_Login.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}