package com.fernandacm.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_type;
    @Index
    private int id_pok;
    @Index
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_pok() {
        return id_pok;
    }

    public void setId_pok(int id_pok) {
        this.id_pok = id_pok;
    }
}
