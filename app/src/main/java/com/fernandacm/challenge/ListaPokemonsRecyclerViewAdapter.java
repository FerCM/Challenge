package com.fernandacm.challenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fernandacm.challenge.Models.Ability;
import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.Models.Types;

import java.util.List;


/**
 * Created by ERodriguezF on 18/12/2017.
 * @author ERodriguezF
 * @version 1.18
 */

public class ListaPokemonsRecyclerViewAdapter extends RecyclerView.Adapter<ListaPokemonViewHolder>{

    private List<Pokemon> items;
    private Context context;
    private IPokeListItemOnClickListener listener;

    public ListaPokemonsRecyclerViewAdapter(List<Pokemon> items,Context context, IPokeListItemOnClickListener listener ){
        System.out.println("Lista Pokemon View Adapter..................................................");
        System.out.println("items" + items);
        this.items = items;
        this.listener = listener;
        this.context = context;

       // this.listener = listener;
    }
    @NonNull
    @Override
    public ListaPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("Vista Card*******************************");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ListaPokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPokemonViewHolder holder, int position) {
      // System.out.println("Position: " + position);
      //  System.out.println("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+(position + 1)+".png");
        Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ items.get(position).getId() +".png" ).into(holder.getIconImageView());
        holder.getNameTextView().setText(items.get(position).getName());
        holder.getIdTextView().setText("#"+items.get(position).getId());
        String types;
        for(int i = 0; i<items.get(position).getTypes().size(); i++){
            System.out.println(items.get(position).getTypes().get(i));
        }
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Cliiickkkk");
                listener.onClick(context,items.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
