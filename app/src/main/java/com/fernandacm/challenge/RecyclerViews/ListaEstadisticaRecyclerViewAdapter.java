package com.fernandacm.challenge.RecyclerViews;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.Models.Stat;
import com.fernandacm.challenge.Models.Type;
import com.fernandacm.challenge.R;

import java.util.List;

public class ListaEstadisticaRecyclerViewAdapter extends RecyclerView.Adapter<ListaEstadisticasViewHolder>{

    private List<Stat> items;
    private Context context;

    public ListaEstadisticaRecyclerViewAdapter(List<Stat> items,Context context){
        System.out.println("Estadisticas: " + items);
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ListaEstadisticasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_estadisticas, parent, false);
        return new ListaEstadisticasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaEstadisticasViewHolder holder, int position) {
        System.out.println("Hola? " + items.get(position).getName());
        System.out.println("Hola numero "  +  String.valueOf(items.get(position).getId_pokemon_base()));
        String aux = "" +items.get(position).getId_pokemon_base();
        holder.getName_estadisticaTextView().setText(items.get(position).getName());
        holder.getValue_estadisticaTextView().setText(String.valueOf(items.get(position).getId_pokemon_base()));

    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
