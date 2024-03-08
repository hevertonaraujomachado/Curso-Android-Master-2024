package com.devheverton.blocodenotas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devheverton.blocodenotas.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencia preferencia;
     private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fbSalvar = findViewById(R.id.fb_salvar);
        editAnotacao = findViewById(R.id.editAnotacao);

        preferencia = new AnotacaoPreferencia(getApplicationContext());
        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoRecuperado = editAnotacao.getText().toString();

                if (textoRecuperado.equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha a anotação", Toast.LENGTH_LONG).show();
                } else {
                    preferencia.salvarAnotacao(textoRecuperado);
                    Toast.makeText(getApplicationContext(), "Anotação Salva com Sucesso", Toast.LENGTH_LONG).show();
                }
            }
        });
        String anotacao = preferencia.recuperarAnotacao();
        if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);

        }
    }}