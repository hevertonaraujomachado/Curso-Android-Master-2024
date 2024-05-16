package com.devhevertonaraujo.previsodotempo.services

import com.devhevertonaraujo.previsodotempo.model.Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
//chave api(d88582ad425e5e104c6e3382acca34f2)
interface Api {

   @GET("weather")
   fun weatherMap(
       @Query("q") cityName: String,
       @Query("appid") apikey: String

   ): Call<Main>
}