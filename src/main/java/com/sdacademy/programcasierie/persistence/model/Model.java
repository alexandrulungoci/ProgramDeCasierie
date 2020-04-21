package com.sdacademy.programcasierie.persistence.model;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
