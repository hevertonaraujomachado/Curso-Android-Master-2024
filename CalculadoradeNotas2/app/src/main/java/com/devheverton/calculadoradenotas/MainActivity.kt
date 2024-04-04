package com.devheverton.calculadoradenotas


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devheverton.calculadoradenotas.R.color.green
import com.devheverton.calculadoradenotas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {
            val nota1 = binding.editNota1.text.toString()
            val nota2 = binding.editNota2.text.toString()
            val nota3 = binding.editNota3.text.toString()
            val nota4 = binding.editNota4.text.toString()
            val numerosFaltas = binding.editFaltas.text.toString()

            if (nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty() || numerosFaltas.isEmpty()){
              binding.txtResultado.setText("Preencha todos os campos!")
            binding.txtResultado.setTextColor(getColor(R.color.red))

        }else{
            calcularMedia(nota1.toInt() , nota2.toInt() , nota3.toInt() , nota4.toInt() , numerosFaltas.toInt())
            }

        }
    }


        fun calcularMedia(nota1:Int,nota2:Int, nota3:Int, nota4:Int, numerosFaltas:Int ) {
            val media = (nota1 + nota2 + nota3 + nota4) / 4
            if (media >= 5 && numerosFaltas <= 20) {
                binding.txtResultado.setText("Aluno foi Aprovado \n Média final: $media")
                binding.txtResultado.setTextColor(getColor(green))
            } else if (numerosFaltas >20) {
                binding.txtResultado.setText("Aluno foi Reprovado por Falta \n Média final: $media")
                binding.txtResultado.setTextColor(getColor(R.color.red))

            }else if (media <5)
                binding.txtResultado.setText("Aluno foi Reprovado por Nota \n Média final: $media")
            binding.txtResultado.setTextColor(getColor(R.color.red))

        }
    }



