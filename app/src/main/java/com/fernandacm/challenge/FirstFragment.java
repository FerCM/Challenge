package com.fernandacm.challenge;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.ApiService.ViewPokemons;
import com.fernandacm.challenge.ApiService.apiPresenter;
import com.fernandacm.challenge.Models.Ability;
import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FirstFragment extends Fragment implements ViewPokemons {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    private apiPresenter pokeServicio;
    ArrayList<Pokemon> pokeList = new ArrayList<>();
    boolean mostrar = false;
    View rootView;
  //  private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        System.out.println("OnCreateView");
        pokeServicio = new apiPresenter(this);
        pokeServicio.getPokemons();
        rootView = inflater.inflate(R.layout.fragment_first, container, false);


         return rootView;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
      //  binding = null;
    }
    @Override
    public void onPokeSucess(ResponseRetrofit pokemons) {
       ArrayList <Pokemon> auxList = pokemons.getResults();
        for( int i = 0; i< auxList.size(); i++){
            //  System.out.println("Aqui el poke: " + auxList.get(i).getName());
            pokeServicio.getDetailPoke(auxList.get(i).getName());
            System.out.println(auxList.size() + "i? " + i);
            if(auxList.size() == (i+1)){
                mostrar = true;
            }else{

            }
        }
    }

    @Override
    public void onPokeError() {

    }

    @Override
    public void onDetailSucess(Pokemon detail) {
        System.out.println("Hola! Estoy en detalle de pokemon :) ");
        this.pokeList.add(detail);
        System.out.println(mostrar);
        if(mostrar){
            recyclerView = rootView.findViewById(R.id.recyclerview);
            unbinder = ButterKnife.bind(this, rootView);


            ListaPokemonsRecyclerViewAdapter adapter = new ListaPokemonsRecyclerViewAdapter(pokeList, getContext(),  new IPokeListItemOnClickListener() {
                @Override
                public void onClick(Context context, Pokemon item) {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            });
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onDetailError() {
        System.out.println("Error? ");
    }

    @Override
    public void onConecctionError() {

    }
}