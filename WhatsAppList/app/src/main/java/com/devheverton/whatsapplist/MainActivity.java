package com.devheverton.whatsapplist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devheverton.whatsapplist.Adapter.AdapterUsuario;
import com.devheverton.whatsapplist.Model.Usuario;
import com.devheverton.whatsapplist.RecycleItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_usuarios;
    private List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_usuarios = findViewById(R.id.recycler_usuarios);

        recycler_usuarios.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recycler_usuarios.setHasFixedSize(true);

        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        recycler_usuarios.setAdapter(adapterUsuario);

        Usuarios();

        recycler_usuarios.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), recycler_usuarios, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Usuario usuario = usuarioList.get(position);
                Toast.makeText(getApplicationContext(), "Usuário" + usuario.getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Usuario usuario = usuarioList.get(position);
                Toast.makeText(getApplicationContext(), "Usuário" + usuario.getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        ) {

        });

    }

    public void Usuarios() {

        Usuario usuario1 = new Usuario(R.drawable.usuario1, "Héverton", "olá como vai?");
        usuarioList.add(usuario1);

        Usuario usuario2 = new Usuario(R.drawable.usuario2, "Bruna", "olá como vai?");
        usuarioList.add(usuario2);

        Usuario usuario3 = new Usuario(R.drawable.usuario1, "Pedro", "Vou na sua casa amanhã?");
        usuarioList.add(usuario3);

        Usuario usuario4 = new Usuario(R.drawable.usuario2, "Maria", "Eu Estou bem e você?");
        usuarioList.add(usuario4);

        Usuario usuario5 = new Usuario(R.drawable.usuario1, "Jacob", "okyes!");
        usuarioList.add(usuario5);

        Usuario usuario6 = new Usuario(R.drawable.usuario2, "Pitty", "Na sua Estante ?");
        usuarioList.add(usuario6);

        Usuario usuario7 = new Usuario(R.drawable.usuario1, "Mateus", "I am Fine!");
        usuarioList.add(usuario7);

        Usuario usuario8 = new Usuario(R.drawable.usuario2, "livia", "oi vida?");
        usuarioList.add(usuario8);

        Usuario usuario9 = new Usuario(R.drawable.usuario1, "Jonas", "Jesus te ama!");
        usuarioList.add(usuario9);

        Usuario usuario10 = new Usuario(R.drawable.usuario2, "Carla", "olá como está?");
        usuarioList.add(usuario10);

        Usuario usuario11 = new Usuario(R.drawable.usuario1, "David", "Bom dia");
        usuarioList.add(usuario11);

        Usuario usuario12 = new Usuario(R.drawable.usuario2, "livia", "Boa noite!");
        usuarioList.add(usuario12);
    }
}