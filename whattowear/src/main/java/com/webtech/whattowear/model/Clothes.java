package com.webtech.whattowear.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean waterproof;
    private String brand;

    public Clothes() {}

    public Clothes(String name, boolean waterproof) {
        this.name = name;
        this.waterproof = waterproof;
    }

    public Integer getId(){ return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() { return name; }

    public void setName(String name) {this.name = name;}

    // Constructors, getters, setters, and other methods as needed
}
