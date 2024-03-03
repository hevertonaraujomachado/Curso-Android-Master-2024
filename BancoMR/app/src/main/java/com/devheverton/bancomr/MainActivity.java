package com.devheverton.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devheverton.bancomr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegarTelaDeSaldo = new Intent(MainActivity.this, Saldo.class);
                startActivity(navegarTelaDeSaldo);
finish();
            }
        });
        binding.imgFaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelasFaturas = new Intent(MainActivity.this, Faturas.class);
                startActivity(navegarTelasFaturas);
                finish();
            }
        });
        binding.imgTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelasTransferencia = new Intent(MainActivity.this, Transferencia.class);
                startActivity(navegarTelasTransferencia);
                finish();
            }
        });
        binding.imgPoupanA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarTelaPoupanca = new Intent(MainActivity.this, Poupanca.class);
                startActivity(navegarTelaPoupanca);
                finish();
            }
        });
    }
}