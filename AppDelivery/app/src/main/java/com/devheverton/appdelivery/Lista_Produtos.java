package com.devheverton.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

public class Lista_Produtos extends AppCompatActivity {

    private RecyclerView recyclerView_produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

recyclerView_produtos = findViewById(R.id.recycleView_produtos);

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