package com.fernandacm.challenge.RecyclerViews;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandacm.challenge.R;


public class ListaEstadisticasViewHolder extends RecyclerView.ViewHolder{


    private CardView cardView;
    private TextView name_estadisticaTextView;
    private TextView value_estadisticaTextView;
    public ListaEstadisticasViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_estadisticas);
        name_estadisticaTextView = itemView.findViewById(R.id.name_estadistica);
        value_estadisticaTextView = itemView.findViewById(R.id.value_estadistica);
    }
    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public TextView getName_estadisticaTextView() {
        return name_estadisticaTextView;
    }

    public void setName_estadisticaTextView(TextView name_estadisticaTextView) {
        this.name_estadisticaTextView = name_estadisticaTextView;
    }

    public TextView getValue_estadisticaTextView() {
        return value_estadisticaTextView;
    }

    public void setValue_estadisticaTextView(TextView value_estadisticaTextView) {
        this.value_estadisticaTextView = value_estadisticaTextView;
    }
}

