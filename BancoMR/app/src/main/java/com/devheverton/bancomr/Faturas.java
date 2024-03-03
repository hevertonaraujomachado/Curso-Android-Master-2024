package com.devheverton.bancomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devheverton.bancomr.databinding.ActivityFaturasBinding;
import com.vinaygaba.creditcardview.CardType;
import com.vinaygaba.creditcardview.CreditCardView;

public class Faturas extends AppCompatActivity {
    private ActivityFaturasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFaturasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbarFaturas.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarTelaPrincipal = new Intent(Faturas.this, MainActivity.class);
                startActivity(voltarTelaPrincipal);
            }
        });

        CreditCardView cartaoDeCredito = binding.cartaoDeCredito;
        cartaoDeCredito.setCardNumber("4856 6456 7564 7748");
        cartaoDeCredito.setCardName("Heverton Araujo");
        cartaoDeCredito.setExpiryDate("12/25");
        cartaoDeCredito.setType(CardType.VISA);
    }
}