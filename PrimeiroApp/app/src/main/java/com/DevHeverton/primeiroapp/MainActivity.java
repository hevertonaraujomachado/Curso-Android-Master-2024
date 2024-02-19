package com.DevHeverton.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClickAqui = findViewById(R.id.id_btnClickAqui);
        TextView txtMensagem = findViewById(R.id.txtMensagem);

        btnClickAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMensagem.setText(" O usuario foi Cadastrado");
                //Toast.makeText(MainActivity.this,"Botão foi clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}