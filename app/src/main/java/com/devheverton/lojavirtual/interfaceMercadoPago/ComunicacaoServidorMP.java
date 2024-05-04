package com.devheverton.lojavirtual.interfaceMercadoPago;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ComunicacaoServidorMP {

    @Headers({
            "Content-Type: application/json"
    })

    @POST()
    Call<JsonObject> enivarPagamento(
            @Url String url,
            @Body JsonObject dados);



}
