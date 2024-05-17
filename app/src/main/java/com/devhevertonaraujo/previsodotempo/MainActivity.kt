package com.devhevertonaraujo.previsodotempo

import android.annotation.SuppressLint
import android.graphics.Color
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


    binding.trocarTema.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked){ //Tema Escuro - Dark Mode
            binding.containerPrincipal.setBackgroundColor(Color.parseColor("#000000"))
            binding.containerInfo.setBackgroundResource(R.drawable.contanier_info_tema_escuro)
            binding.txtTituloInfo.setTextColor(Color.parseColor("#000000"))
            binding.txtTituloInformacoes1.setTextColor(Color.parseColor("#000000"))
            binding.txtTituloInformacoes2.setTextColor(Color.parseColor("#000000"))
            window.statusBarColor = Color.parseColor("#000000")
        }else{ //Tema Claro
            binding.containerPrincipal.setBackgroundColor(Color.parseColor("#396BCB"))
            binding.containerInfo.setBackgroundResource(R.drawable.container_info_tema_claro)
            binding.txtTituloInfo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.txtTituloInformacoes1.setTextColor(Color.parseColor("#FFFFFF"))
            binding.txtTituloInformacoes2.setTextColor(Color.parseColor("#FFFFFF"))
            window.statusBarColor = Color.parseColor("#396BCB")
        }
    }

    binding.btBuscar.setOnClickListener {

        val cidade = binding.editBuscarCidade.text.toString()

        binding.progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
            .create(Api::class.java)

        retrofit.weatherMap(cidade,Const.API_KEY).enqueue(object : Callback<Main>{
            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                if (response.isSuccessful){
                    respostaServidor(response)
                }else{
                    Toast.makeText(applicationContext,"Cidade inválida!",Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<Main>, t: Throwable) {
                Toast.makeText(applicationContext,"Erro fatal de servidor!",Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }

        })
    }


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

    @SuppressLint("SetTextI18n")
    private fun respostaServidor(response: Response<Main>) {

        val main = response.body()!!.main
        val temp = main.get("temp").toString()
        val tempMin = main.get("temp_min").toString()
        val tempMax = main.get("temp_max").toString()
        val humidity = main.get("humidity").asString

        val sys = response.body()!!.sys
        val country = sys.get("country").toString()
        var pais = ""

        val weather = response.body()!!.weather
        val main_weather = weather[0].main
        val description = weather[0].description

        val name = response.body()!!.name

        val temp_c = (temp.toDouble() - 273.15)
        val tempMin_c = (tempMin.toDouble() - 273.15)
        val tempMax_c = (tempMax.toDouble() - 273.15)
        val decimalFormat = DecimalFormat("00")

        if (country.equals("BR")) {
            pais = "Brasil"
        } else if(country.equals("US")){
            pais = "Estados Unidos"
        }

        if (main_weather.equals("Clouds") && description.equals("few clouds")) {
            binding.imgClima.setImageResource(R.drawable.flewclouds)
        }else if (main_weather.equals("Clouds") && description.equals("scattered clouds")){
            binding.imgClima.setImageResource(R.drawable.clouds)
        }else if (main_weather.equals("Clouds") && description.equals("broken clouds")){
            binding.imgClima.setImageResource(R.drawable.brokenclouds)
        }else if ( main_weather.equals("clouds") && description.equals("overcast clouds")){
            binding.imgClima.setImageResource(R.drawable.brokenclouds)
         }else if ( main_weather.equals("clear") && description.equals("clear sky")){
        binding.imgClima.setImageResource(R.drawable.clearsky)

    }else if ( main_weather.equals("Snow")){
        binding.imgClima.setImageResource(R.drawable.snow)

    }else if ( main_weather.equals("Rain")){
        binding.imgClima.setImageResource(R.drawable.rain)

    }else if ( main_weather.equals("Drizzie")){
        binding.imgClima.setImageResource(R.drawable.rain)

        }else if ( main_weather.equals("Thundertorm")){
            binding.imgClima.setImageResource(R.drawable.trunderstorm)
        }

        val descricaoClima = when(description){
            "clear sky" -> {
                "Céu limpo"
            }
            "few clouds" -> {
                "Poucas nuvens"
            }
            "scattered clouds" -> {
                "Nuvens dispersas"
            }
            "broken clouds" -> {
                "Nuvens quebradas"
            }
            "shower rain" -> {
                "chuva de banho"
            }
            "rain" -> {
                "Chuva"
            }
            "thunderstorm" -> {
                "Tempestade"
            }
            "snow" -> {
                "Neve"
            }
            else -> {
                "Névoa"
            }
        }

    binding.txtTemperatura.setText("${decimalFormat.format(temp_c)}°C")
        binding.txtPaisCidade.setText(" $pais - $name")

        binding.txtTituloInformacoes1.setText("Clima \n $description  \n\n Umidade \n $humidity")
        binding.txtTituloInformacoes2.setText("Temp.Min \n ${decimalFormat.format(tempMin_c)}°C \n\n Temp.Max \n ${decimalFormat.format(tempMax_c)}°C")
        binding.progressBar.visibility = View.GONE

    }
}
