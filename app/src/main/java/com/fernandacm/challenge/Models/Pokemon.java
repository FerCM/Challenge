package com.fernandacm.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    //@JSON(name = "name")
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD;
    @Index
    int id;
    @Index
    String name;
    @Index
    int order;
    private List<Types> types;
    private List<Stats> stats;
    @Index
    private int base_experience;
    @Index
    private int height;
    @Index
    private int weight;
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
