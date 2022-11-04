package com.fernandacm.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_stat;
    @Index
    int id_pokemon;
    @Index
    int id_pokemon_base;
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

    public int getId_pokemon_base() {
        return id_pokemon_base;
    }

    public void setId_pokemon_base(int id_pokemon_effort) {
        this.id_pokemon_base = id_pokemon_effort;
    }
}
