package com.fernandacm.challenge.RecyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.fernandacm.challenge.IPokeListItemOnClickListener;
import com.fernandacm.challenge.Models.Pokemon;
import com.fernandacm.challenge.R;

import java.util.List;

public class ListaPokemonsRecyclerViewAdapter extends RecyclerView.Adapter<ListaPokemonViewHolder>{

    private List<Pokemon> items;
    private Context context;
    private IPokeListItemOnClickListener listener;

    public ListaPokemonsRecyclerViewAdapter(List<Pokemon> items,Context context, IPokeListItemOnClickListener listener ){
        this.items = items;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public ListaPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ListaPokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPokemonViewHolder holder, int position) {
        Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ items.get(position).getId() +".png" ).into(holder.getIconImageView());
        holder.getNameTextView().setText(items.get(position).getName());
        holder.getIdTextView().setText("#"+items.get(position).getId());
        String types = "Types:";
        for (int i = 0; i<items.get(position).getTypes().size(); i++){
            types += " " + items.get(position).getTypes().get(i).getType().getName() ;
        }
        holder.getTypesTextView().setText(types);
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // System.out.println("Cliiickkkk");
                listener.onClick(context,items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
