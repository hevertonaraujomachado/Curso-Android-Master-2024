package com.devheverton.appdefilmes.model

import com.google.gson.annotations.SerializedName

data class Categoria(
    @SerializedName("titulo") val titulo: String? = null,
    @SerializedName("capas") val filmes: MutableList<Filme> = mutableListOf()

)
data class Filme(
   @SerializedName("url_imagem") val capa: String? = null,
    @SerializedName("id") var id: Int = 0

)
data class Categorias(@SerializedName("categoria")
val categorias: MutableList <Categoria> = mutableListOf()

)
