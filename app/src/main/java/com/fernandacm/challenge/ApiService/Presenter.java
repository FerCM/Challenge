package com.fernandacm.challenge.ApiService;

import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;

public interface Presenter {
    // Services
    void getPokemons();
    void getDetailPoke(String name);
    // Response From Services
    void onPokeSucess(ResponseRetrofit pokemons);
    void onPokeError();

    void onDetailSucess(Pokemon detail);
    void onDetailError();


    //General Errors
    void onConecctionError();
}
