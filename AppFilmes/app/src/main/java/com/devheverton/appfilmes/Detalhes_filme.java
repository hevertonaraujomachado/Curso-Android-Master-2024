package com.devheverton.appfilmes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detalhes_filme extends AppCompatActivity {

    private ImageView dt_capaFilme,playVideo;
    private TextView dt_tituloFilme,dt_descricaoFilme,dt_elencoFilme;
    private Toolbar toolbar_detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        //getSupportActionBar().hide();
        IniciarComponentes();


        String capa = getIntent().getExtras().getString("capa");
        String titulo = getIntent().getExtras().getString("titulo");
        String descricao = getIntent().getExtras().getString("descricao");
        String elenco = getIntent().getExtras().getString("elenco");
        String video = getIntent().getExtras().getString("video");

        String stVideo = video;


        Glide.with(getApplicationContext()).load(capa).into(dt_capaFilme);
        dt_tituloFilme.setText(titulo);
        dt_descricaoFilme.setText(descricao);
        dt_elencoFilme.setText(elenco);

        //Toolbar
        toolbar_detalhes.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detalhes_filme.this,Video.class);
                intent.putExtra("video",stVideo);
                startActivity(intent);
            }
        });

    }
    public void IniciarComponentes(){
        dt_capaFilme = findViewById(R.id.dt_capaFilme);
        playVideo = findViewById(R.id.playVideo);
        dt_tituloFilme = findViewById(R.id.dt_tituloFilme);
        dt_descricaoFilme = findViewById(R.id.dt_descricaoFilme);
        dt_elencoFilme = findViewById(R.id.dt_elencoFilme);
        toolbar_detalhes = findViewById(R.id.toolbar_detalhes);
    }
}