package com.devhevertonaraujo.previsodotempo

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.devhevertonaraujo.previsodotempo.constantes.Const
import com.devhevertonaraujo.previsodotempo.databinding.ActivityMainBinding

import com.devhevertonaraujo.previsodotempo.model.Main
import com.devhevertonaraujo.previsodotempo.services.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        binding.progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/").build().create(Api::class.java)
        retrofit.weatherMap("Teresina", Const.API_KEY).enqueue(object : Callback<Main> {
            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                if (response.isSuccessful) {
                    respostaServidor(response)
                } else {
                    Toast.makeText(applicationContext, "Cidade invalida!", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<Main>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro Fatal de servidor!", Toast.LENGTH_LONG)
                    .show()
                binding.progressBar.visibility = View.GONE
            }
        })


    }

    private fun respostaServidor(response: Response<Main>) {

        val main = response.body()!!.main
        val temp = main.get("temp").toString()
        val tempMin = main.get("temp_min").toString()
        val tempMax = main.get("temp_max").toString()
        val humidity = main.get("humidity").toString()

        val sys = response.body()!!.sys
        val country = sys.get("country").toString()

        val weather = response.body()!!.weather
        val main_weather = weather[0].main
        val description = weather[0].description

        val name = response.body()!!.name

        val temp_c = (temp.toDouble() - 273.15)
        val tempMin_c = (tempMin.toDouble() - 273.15)
        val tempMax_c = (tempMax.toDouble() - 273.15)
        val decimalFormat = DecimalFormat("00")



        binding.txtTemperatura.setText("${decimalFormat.format(temp_c)}°C")
        binding.txtPaisCidade.setText(" $country - $name")

        binding.txtTituloInformacoes1.setText("Clima \n $description  \n\n Umidade \n $humidity")
        binding.txtTituloInformacoes2.setText("Temp.Min \n ${decimalFormat.format(tempMin_c)}°C \n\n Temp.Max \n ${decimalFormat.format(tempMax_c)}°C")
        binding.progressBar.visibility = View.GONE

    }
}



