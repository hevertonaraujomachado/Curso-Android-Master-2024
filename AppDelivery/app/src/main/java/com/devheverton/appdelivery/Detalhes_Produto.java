package com.devheverton.appdelivery;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class Detalhes_Produto extends AppCompatActivity {

    private ImageView dt_fotoProduto;
    private TextView dt_nomeProduto,dt_descricaoProduto,dt_precoProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        IniciarComponentes();

        String foto = getIntent().getExtras().getString("foto");
        String nome = getIntent().getExtras().getString("nome");
        String descricao = getIntent().getExtras().getString("descricao");
        String preco = getIntent().getExtras().getString("preco");

        Glide.with(getApplicationContext()).load(foto).into(dt_fotoProduto);
        dt_nomeProduto.setText(nome);
        dt_descricaoProduto.setText(descricao);
        dt_precoProduto.setText(preco);


    }

    private void IniciarComponentes() {
        dt_fotoProduto =findViewById(R.id.dt_fotoProduto);
        dt_nomeProduto =findViewById(R.id.dt_nomeProduto);
        dt_descricaoProduto =findViewById(R.id.dt_descricaoProduto);
        dt_precoProduto =findViewById(R.id.dt_precoProduto);
    }
}