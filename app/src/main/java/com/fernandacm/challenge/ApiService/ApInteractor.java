package com.fernandacm.challenge.ApiService;

import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApInteractor implements Interactor {
    private Presenter presenter;

    public ApInteractor(Presenter carpetaPresenter){
        this.presenter = carpetaPresenter;
    }


    @Override
    public void getPokemons() {
        Service services = Builder.Build();
        Call<ResponseRetrofit> pokeService = services.getPokemons();
        pokeService.enqueue(new Callback<ResponseRetrofit>() {
            @Override
            public void onResponse(Call<ResponseRetrofit> call, Response<ResponseRetrofit> response) {
                 if(response.isSuccessful()){
                    ResponseRetrofit pokeRespuesta = response.body();
                    presenter.onPokeSucess(pokeRespuesta);
                }
                else{
                    System.out.println("Error en obtener pokemons" + response);
                    presenter.onPokeError();
                }
            }

            @Override
            public void onFailure(Call<ResponseRetrofit> call, Throwable t) {
                System.out.println("Error get pokemons : " + t.getMessage());
                presenter.onPokeError();
            }
        });
    }

    @Override
    public void getDetailPoke(String nombre) {
        Service services = Builder.Build();
       //Iniciamos petición de detalle:
        Call<Pokemon> pokeDetailService = services.getDetailPoke(nombre);
        pokeDetailService.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
              if(response.isSuccessful()){
                    presenter.onDetailSucess(response.body());
              }
              else{
                  System.out.println("Error " + response);
                  presenter.onDetailError();
              }
            }
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

                System.out.println("Error get pokemons : " + t.getMessage());
                presenter.onDetailError();
            }
        });
    }
}
