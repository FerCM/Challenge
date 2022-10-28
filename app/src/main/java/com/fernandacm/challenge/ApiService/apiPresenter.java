package com.fernandacm.challenge.ApiService;

import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;

public class apiPresenter implements Presenter {

    private ViewPokemons pokeView;
    private Interactor pokemons;

    public apiPresenter(ViewPokemons carpetaView){
        this.pokeView = carpetaView;
        this.pokemons =  new ApInteractor(this);
    }

    @Override
    public void getPokemons() {
        this.pokemons.getPokemons();
    }
    @Override
    public void onPokeSucess(ResponseRetrofit pokemons) {
        this.pokeView.onPokeSucess(pokemons);
    }

    @Override
    public void onPokeError() {this.pokeView.onPokeError();}

    @Override
    public void getDetailPoke(String name) {
        this.pokemons.getDetailPoke(name);
    }
   @Override
    public void onDetailSucess(Pokemon detail) {
        pokeView.onDetailSucess(detail);
    }

    @Override
    public void onDetailError() {
        this.pokeView.onDetailError();
    }

    @Override
    public void onConecctionError() {
        pokeView.onConecctionError();
    }
}
