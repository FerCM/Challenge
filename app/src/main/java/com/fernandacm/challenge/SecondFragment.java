package com.fernandacm.challenge;
import static java.lang.Integer.parseInt;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fernandacm.challenge.Models.ObjectBox;
import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.Pokemon_;
import com.fernandacm.challenge.Models.Stat;
import com.fernandacm.challenge.Models.Stat_;
import com.fernandacm.challenge.Models.Type;
import com.fernandacm.challenge.Models.Type_;
import com.fernandacm.challenge.RecyclerViews.ListaEstadisticaRecyclerViewAdapter;
import com.fernandacm.challenge.RecyclerViews.ListaPokemonsRecyclerViewAdapter;
import com.fernandacm.challenge.RecyclerViews.ListaTypesRecyclerViewAdapter;
import com.fernandacm.challenge.databinding.FragmentSecondBinding;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;
import io.objectbox.query.Query;

public class SecondFragment extends Fragment {
    @BindView(R.id.recyclerview_types_pokemon)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerview_estadisticas_pokemon)
    RecyclerView recyclerView_estadisticas;
    Box<Pokemon> pokeBox;
    List<Pokemon> listaPokemonLocals;
    Box<Type> pokeTypesBox;
    List<Type> listaTypesLocals;
    Box<Stat> pokeStatsBox;
    List <Stat> listaStatsLocals;
    private ImageView iconImageView;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typesTextView, experienciaTextview;
    private LinearLayoutCompat layout;

    View rootView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        rootView = inflater.inflate(R.layout.fragment_second, container, false);
        int id = parseInt(getArguments().getString("Pokemon"));
        pokeBox = ObjectBox.get().boxFor(Pokemon.class);
        pokeTypesBox = ObjectBox.get().boxFor(Type.class);
        pokeStatsBox = ObjectBox.get().boxFor(Stat.class);
        listaPokemonLocals = pokeBox.getAll();
        listaTypesLocals = pokeTypesBox.getAll();
        listaStatsLocals = pokeStatsBox.getAll();

        Query<Pokemon> query = pokeBox
                .query(Pokemon_.id.equal(id))
                .order(Pokemon_.name)
                .build();
        List<Pokemon> result = query.find();
        query.close();
        System.out.println("Pokemon? " + listaPokemonLocals.size());
        /////
        Query<Type> query2 = pokeTypesBox
                .query(Type_.id_pok.equal(id))
                .order(Type_.name)
                .build();
        List<Type> result_type = query2.find();
        recyclerView = rootView.findViewById(R.id.recyclerview_types_pokemon);
        ListaTypesRecyclerViewAdapter adapter = new ListaTypesRecyclerViewAdapter(result_type, getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        query2.close();
        ////////
        Query<Stat> query_stats = pokeStatsBox
                .query(Stat_.id_pokemon.equal(id))
                .order(Stat_.name)
                .build();
        List<Stat> result_stat = query_stats.find();
        query_stats.close();
        recyclerView_estadisticas = rootView.findViewById(R.id.recyclerview_estadisticas_pokemon);
        ListaEstadisticaRecyclerViewAdapter adapter_estadistica = new ListaEstadisticaRecyclerViewAdapter(result_stat, getContext());
        RecyclerView.LayoutManager layoutManager_estadistica = new GridLayoutManager(getContext(), 1);
        recyclerView_estadisticas.setLayoutManager(layoutManager_estadistica);
        recyclerView_estadisticas.setItemAnimator(new DefaultItemAnimator());
        recyclerView_estadisticas.setAdapter(adapter_estadistica);
        ///
        iconImageView = rootView.findViewById(R.id.icon);
        nameTextView = rootView.findViewById(R.id.name);
        idTextView = rootView.findViewById(R.id.id_pokemon);
        //typesTextView = rootView.findViewById(R.id.types_text);

        Glide.with(getContext()).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ id +".png" ).into(iconImageView);
        nameTextView.setText(result.get(0).getName());
        idTextView.setText("#"+result.get(0).getId());
//        typesTextView.setText(aux);

       return rootView;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}