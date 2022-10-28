package com.fernandacm.challenge.Models;

import java.util.ArrayList;

public class AbilityX {
    private ArrayList<Ability> ability;
    private boolean is_hidden;
    private int slot;

    public ArrayList<Ability> getAbility() {
        return ability;
    }

    public void setAbility(ArrayList<Ability> ability) {
        this.ability = ability;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
