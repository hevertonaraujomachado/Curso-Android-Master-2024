package com.devheverton.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devheverton.bancomr.databinding.ActivitySaldoBinding;

public class Saldo extends AppCompatActivity {
    private ActivitySaldoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaldoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbarSaldo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent voltarTelaPrincipal = new Intent(Saldo.this,MainActivity.class);
                //startActivity(voltarTelaPrincipal);
                finish();

            }
        });
    }
}