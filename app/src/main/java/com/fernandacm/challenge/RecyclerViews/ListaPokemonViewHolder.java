package com.fernandacm.challenge.RecyclerViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.R;

public class ListaPokemonViewHolder extends RecyclerView.ViewHolder{


    private CardView cardView;
    private ImageView iconImageView;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typesTextView;
    public ListaPokemonViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_pokemons);
        iconImageView = itemView.findViewById(R.id.icon);
        nameTextView = itemView.findViewById(R.id.name);
        idTextView = itemView.findViewById(R.id.id_pokemon);
        typesTextView = itemView.findViewById(R.id.types);
    }
  public CardView getCardView() {
        return cardView;
    }

    public ImageView getIconImageView() {
        return iconImageView;
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.nameTextView = nameTextView;
    }

    public TextView getIdTextView() {
        return idTextView;
    }

    public void setIdTextView(TextView idTextView) {
        this.idTextView = idTextView;
    }

    public TextView getTypesTextView() {
        return typesTextView;
    }

    public void setTypesTextView(TextView typesTextView) {
        this.typesTextView = typesTextView;
    }
}

