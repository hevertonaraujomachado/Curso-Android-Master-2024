package com.devheverton.appnumber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.devheverton.appnumber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }
    private void calcular(){
        int numero = Integer.parseInt(binding.editNumero.getText().toString());

        if ( numero % 2 == 0){
            binding.txtResultado.setText("O número "  +  numero  + " é Par");
        }else{
            binding.txtResultado.setText("O número " +  numero  + " é Impar");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.ic_limap){
            binding.editNumero.setText("");
            binding.txtResultado.setText("");
        }
        return super.onOptionsItemSelected(item);
    }
}