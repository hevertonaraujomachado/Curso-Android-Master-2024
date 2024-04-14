package com.devheverton.appcep

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.devheverton.appcep.api.Api
import com.devheverton.appcep.databinding.ActivityMainBinding
import com.devheverton.appcep.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://viacep.com.br/ws/").build()
            .create(Api::class.java)

        binding.btBuscarCep.setOnClickListener {

            val cep = binding.editCep.text.toString()

            if (cep.isEmpty()) {
                Toast.makeText( this, "Preencha o cep!", Toast.LENGTH_SHORT).show()
            }else{
                retrofit.setEndereco(cep).enqueue(object : Callback<Endereco>{
                    override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                        if (response.code() == 200){
                            val logradouro = response.body()?.logradouro.toString()
                            val bairro = response.body()?.bairro.toString()
                            val localidade = response.body()?.localidade.toString()
                            val uf = response.body()?.uf.toString()
                            setFormularios(logradouro,bairro,localidade,uf)

                        }else{
                            Toast.makeText( applicationContext, "Cep Invalido!", Toast.LENGTH_SHORT).show()

                        }
                    }

                    override fun onFailure(call: Call<Endereco>, t: Throwable) {
                        Toast.makeText( applicationContext, "Erro inesperado!", Toast.LENGTH_SHORT).show()
                    }

                } )

        }
    }
}
    private fun setFormularios(logradouro: String, bairro: String, localidade: String, uf: String){
        binding.editLogradouro.setText(logradouro)
        binding.editBairro.setText(bairro)
        binding.editCidade.setText(localidade)
        binding.editEstado.setText(uf)

    }
}