package com.fernandacm.challenge.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.Transient;

@Entity
public class Stats implements Serializable {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_abilities;
    int base_stat;
    int effot;

    @Transient
    private Stat stat;

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffot() {
        return effot;
    }

    public void setEffot(int effot) {
        this.effot = effot;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
