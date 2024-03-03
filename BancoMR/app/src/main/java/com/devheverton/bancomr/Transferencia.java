package com.devheverton.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devheverton.bancomr.databinding.ActivityFaturasBinding;
import com.devheverton.bancomr.databinding.ActivityTransferenciaBinding;

public class Transferencia extends AppCompatActivity {
    private ActivityTransferenciaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransferenciaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbarTransferencia.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarTelaPrincipal = new Intent(Transferencia.this,MainActivity.class);
                startActivity(voltarTelaPrincipal);
            }
        });
    }


}