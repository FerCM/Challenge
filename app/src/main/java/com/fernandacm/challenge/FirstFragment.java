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
import com.fernandacm.challenge.Models.ObjectBox;
import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.ResponseRetrofit;
import com.fernandacm.challenge.Models.Stat;
import com.fernandacm.challenge.Models.Type;
import com.fernandacm.challenge.RecyclerViews.ListaPokemonsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.objectbox.Box;

public class FirstFragment extends Fragment implements ViewPokemons {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    private apiPresenter pokeServicio;
    List<Pokemon> pokeList = new ArrayList<>();
    int number = 0;
    boolean mostrar = false;
    View rootView;
    Box<Pokemon> pokeBox;
    List <Pokemon> listaPokemonLocals;
    Box<Type> pokeTypesBox;
    List <Type> listaTypesLocals;
    Box<Stat> pokeStatsBox;
    List <Stat> listaStatsLocals;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //GET pokeBox
        pokeList = new ArrayList<>();
        pokeBox = ObjectBox.get().boxFor(Pokemon.class);
        listaPokemonLocals = pokeBox.getAll();
        pokeTypesBox = ObjectBox.get().boxFor(Type.class);
        listaTypesLocals = pokeTypesBox.getAll();
        pokeStatsBox = ObjectBox.get().boxFor(Stat.class);
        listaStatsLocals = pokeStatsBox.getAll();

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
       number = auxList.size();
        for( int i = 0; i< auxList.size(); i++){
            pokeServicio.getDetailPoke(auxList.get(i).getName());
            if(auxList.size() == (i+1)){
                mostrar = true;
            }
        }
    }

    @Override
    public void onPokeError() {

    }

    @Override
    public void onDetailSucess(Pokemon detail) {
        this.pokeList.add(detail);
        if(pokeBox.getAll().size() <= 20 ){
            pokeBox.put(detail);
            for(int i = 0; i< detail.getTypes().size(); i++){
                Type aux = detail.getTypes().get(i).getType();
                aux.setId_pok(detail.getId());
                pokeTypesBox.put(aux);
            }
            for(int i = 0; i< detail.getStats().size(); i++){
                Stat aux = detail.getStats().get(i).getStat();
                aux.setId_pokemon(detail.getId());
                aux.setId_pokemon_base(detail.getStats().get(i).getBase_stat());
                pokeStatsBox.put(aux);
            }
        }
        if(mostrar){
            print();
        }

    }

    public void print(){
        recyclerView = rootView.findViewById(R.id.recyclerview);
        unbinder = ButterKnife.bind(this, rootView);
        ListaPokemonsRecyclerViewAdapter adapter = new ListaPokemonsRecyclerViewAdapter(pokeList, getContext(),  new IPokeListItemOnClickListener() {
            @Override
            public void onClick(Context context, Pokemon item) {
                Bundle result = new Bundle();
                result.putString("Pokemon", "" + item.getId());
                getParentFragmentManager().setFragmentResult("Pokemon", result);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDetailError() {
        System.out.println("Error? ");
    }

    @Override
    public void onConecctionError() {

    }
}