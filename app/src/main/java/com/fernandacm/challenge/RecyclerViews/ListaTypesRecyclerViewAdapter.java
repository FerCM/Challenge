package com.fernandacm.challenge.RecyclerViews;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.IPokeListItemOnClickListener;
import com.fernandacm.challenge.Models.Type;
import com.fernandacm.challenge.R;

import java.util.List;

public class ListaTypesRecyclerViewAdapter extends RecyclerView.Adapter<ListaTypesViewHolder>{

    private List<Type> items;
    private Context context;

    public ListaTypesRecyclerViewAdapter(List<Type> items,Context context){
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ListaTypesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("Vista Card*******************************");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_types, parent, false);
        return new ListaTypesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaTypesViewHolder holder, int position) {
        holder.getNameTextView().setText(items.get(position).getName());
       // holder.getCardView().setBackgroundColor(Color.CYAN);

    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
