package com.devheverton.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form_Login extends AppCompatActivity {

    private TextView txt_criar_conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        getSupportActionBar().hide();
AbrirForm_Login();

txt_criar_conta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Form_Login.this,Form_Cadastro.class);
        startActivity(intent);
    }
});
    }
    public void AbrirForm_Login(){
        txt_criar_conta = findViewById(R.id.txt_criar_conta);

    }
}
