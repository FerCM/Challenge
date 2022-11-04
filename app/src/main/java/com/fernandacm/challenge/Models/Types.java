package com.fernandacm.challenge.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Transient;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Types {
    @io.objectbox.annotation.Id( assignable = true)
    public long Id_BD_types;

    @Transient
    private  Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
