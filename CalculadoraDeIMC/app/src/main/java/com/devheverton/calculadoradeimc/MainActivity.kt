package com.devheverton.calculadoradeimc

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity

import com.devheverton.calculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.btCalcular
        val mensagem = binding.mensagem

        bt_calcular.setOnClickListener {
            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            if (editPeso.isEmpty()){
                mensagem.setText("Informe o seu Peso")
            }else if (editAltura.isEmpty()){
                mensagem.setText("Informe a sua Altura")
            }else{
                CalcularDeIMC()
            }
        }

    }
    private fun CalcularDeIMC(){
        val pesoId = binding.editPeso
        val alturaId = binding.editAltura

        val peso = Integer.parseInt(pesoId.text.toString())
        val altura = java.lang.Float.parseFloat(alturaId.text.toString())
        val resultado = binding.mensagem
        val imc = peso / (altura * altura)

        val Mensagem = when{
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobre Peso"
            imc <= 34.9 -> "Obsidade ( Grau I)"
            imc <= 39.9 -> "Obsidade Severa ( Grau II)"
            else -> "Obsidade Mórbida ( Grau III)"

                 }

        imc.toString()
        resultado.setText("IMC: $imc \n $Mensagem")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_pricipal, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.limpar ->{

                val limparEditPeso = binding.editPeso
                val limparEditAltura = binding.editAltura
                val limparMensagem = binding.mensagem


                limparEditPeso.setText("")
                limparEditAltura.setText("")
                limparMensagem.setText("")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}