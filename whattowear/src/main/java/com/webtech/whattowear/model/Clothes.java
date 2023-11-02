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
    private String category;
    private Long minTemp;
    private Long maxTemp;

    private String pathPic;

    public Clothes() {}

    public Clothes(String category, Long minTemp, Long maxTemp) {
        this.category = category;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public Integer getId(){ return id;}

    public void setId(Integer id) {this.id = id;}

    public void setCategory(String category) {this.category = category;}

    // Constructors, getters, setters, and other methods as needed
}
