package com.fernandacm.challenge.RecyclerViews;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.R;

public class ListaTypesViewHolder extends RecyclerView.ViewHolder{


    private CardView cardView;
    private TextView name_typesTextView;
    public ListaTypesViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_types);
        name_typesTextView = itemView.findViewById(R.id.name_types);
      }
    public CardView getCardView() {
        return cardView;
    }


    public TextView getNameTextView() {
        return name_typesTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.name_typesTextView = nameTextView;
    }


}

