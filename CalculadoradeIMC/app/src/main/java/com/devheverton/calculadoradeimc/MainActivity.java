package com.devheverton.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.devheverton.calculadoradeimc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String peso = binding.editPeso.getText().toString();
                String altura = binding.editAltura.getText().toString();

                if (peso.isEmpty()) {
                    binding.editPeso.setError("Informe seu Peso!");
                } else if (altura.isEmpty()) {
                    binding.editAltura.setError("Informe a sua Altura");

                } else {
                    calcularImc();
                }
            }


        });
    }

    private void calcularImc() {
        float peso = Float.parseFloat(binding.editPeso.getText().toString());
        float altura = Float.parseFloat(binding.editAltura.getText().toString());
        float imc = peso / (altura * altura);

        if (imc < 18.5) {
            binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Peso Baixo");
        } else if (imc <= 24.9) {
            binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Peso Normail");

        } else if (imc <= 29.9) {
            binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Sobrepeso");
        } else if (imc <= 34.9) {
            binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Obsidade (Grau I)");


        } else if (imc <= 39.9) {
            binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Obsidade (Grau II)");

        }else if (imc >= 40.0) {
        binding.txtResultado.setText("Seu IMC é de " + imc + "\n" + "Obsidade (Grau III)");
    }
}
}