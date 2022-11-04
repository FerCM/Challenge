package com.fernandacm.challenge.ApiService;


import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("api/v2/pokemon/")
    Call<ResponseRetrofit> getPokemons();

    @GET("api/v2/pokemon/{name}")
    Call<Pokemon> getDetailPoke(@Path("name") String name);

    //Url de imagen https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/{{id}}.png

}