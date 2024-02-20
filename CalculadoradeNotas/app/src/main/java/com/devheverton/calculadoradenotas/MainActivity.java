package com.devheverton.calculadoradenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText n1,n2,n3,n4,numeroDeFaltas;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota2);
        n3 = findViewById(R.id.nota3);
        n4 = findViewById(R.id.nota4);
        numeroDeFaltas = findViewById(R.id.numeroDeFaltas);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nota1 = Integer.parseInt(n1.getText().toString());
                int nota2 = Integer.parseInt(n2.getText().toString());
                int nota3 = Integer.parseInt(n3.getText().toString());
                int nota4 = Integer.parseInt(n4.getText().toString());
                int numerosDe_Faltas = Integer.parseInt(numeroDeFaltas.getText().toString());
                int media = (nota1 + nota2 + nota3 + nota4 ) /4;

if ( media >= 5 && numerosDe_Faltas <= 20){
    txtResultado.setText("Aluno foi Aprovado \n"+ "Média Final" + media);
    txtResultado.setTextColor(getColor(R.color.TEAL_3000));
}else if (numerosDe_Faltas>20){
    txtResultado.setText("Aluno foi Reporvado por Faltas \n" + "Media Final" + media);
    txtResultado.setTextColor(getColor(R.color.RED_3000));
}else if (media < 5){
    txtResultado.setText("Aluno foi Reporvado por Faltas \n" + "Media Final" + media);
    txtResultado.setTextColor(getColor(R.color.RED_3000));
}

            }
        });
    }
}