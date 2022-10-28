package com.fernandacm.challenge.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class BaseServiceBuilder {
    public static Retrofit Build(){
        return new Retrofit.Builder().baseUrl("https://pokeapi.co/").addConverterFactory(JacksonConverterFactory.create()).build();
    }



}
