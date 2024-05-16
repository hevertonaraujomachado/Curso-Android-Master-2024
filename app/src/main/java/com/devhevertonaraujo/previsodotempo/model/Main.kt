package com.devhevertonaraujo.previsodotempo.model

import org.json.JSONObject

data class Main(
    val main: JSONObject,
    val sys: JSONObject,
    val weather : List<Weather>,
    val name: String
)