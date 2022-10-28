package com.fernandacm.challenge.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Abilities implements Serializable {
    private ArrayList<AbilityX> ability;

    public ArrayList<AbilityX> getAbility() {
        return ability;
    }

    public void setAbility(ArrayList<AbilityX> ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Abilities: " + ability.toString();
    }
}
