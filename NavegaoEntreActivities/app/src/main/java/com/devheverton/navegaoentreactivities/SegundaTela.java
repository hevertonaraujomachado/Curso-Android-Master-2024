package com.devheverton.navegaoentreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devheverton.navegaoentreactivities.databinding.ActivityMainBinding;
import com.devheverton.navegaoentreactivities.databinding.ActivitySegundaTelaBinding;

public class SegundaTela extends AppCompatActivity {
private ActivitySegundaTelaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaTelaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaTela.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}