package com.fernandacm.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.Transient;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats implements Serializable {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_starts;
    @Index
    int base_stat;
    @Index
    int effort;

    @Transient
    private Stat stat;

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
