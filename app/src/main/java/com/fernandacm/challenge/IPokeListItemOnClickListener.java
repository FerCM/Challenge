package com.fernandacm.challenge;

import android.content.Context;

import com.fernandacm.challenge.Models.Pokemon;

public interface IPokeListItemOnClickListener {
    void onClick(Context context, Pokemon item);
}
