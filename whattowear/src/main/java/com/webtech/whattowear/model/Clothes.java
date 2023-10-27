package com.webtech.whattowear.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clothes {
    @Id
    private Integer id;
    private String title;
    private boolean waterproof;
    private String brand;

    // Constructors, getters, setters, and other methods as needed
}
