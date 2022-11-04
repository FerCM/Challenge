package com.fernandacm.challenge.Models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;

@Entity
public class Stat {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_ability;
    @Index
    int id_pokemon;
    @Index
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(int id_pokemon) {
        this.id_pokemon = id_pokemon;
    }
}
