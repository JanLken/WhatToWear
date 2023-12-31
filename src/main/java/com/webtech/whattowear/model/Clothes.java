package com.webtech.whattowear.model;

import com.webtech.whattowear.service.ClothesService;
import jakarta.persistence.*;


@Entity
@Table(name ="clothes")
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="category", nullable = false)
    private String category;
    @Column(name ="minimal_temperature", nullable = false)
    private Long minTemp;
    @Column(name ="maximum_temperature", nullable = false)
    private Long maxTemp;

    public Clothes() {}

    public Clothes(String category, Long minTemp, Long maxTemp) {
        this.category = category;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Long minTemp) {
        this.minTemp = minTemp;
    }

    public Long getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Long maxTemp) {
        this.maxTemp = maxTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothesService)) return false;

        Clothes clothes = (Clothes) o;

        if (getMinTemp() != clothes.getMinTemp()) return false;
        if (getId() != null ? !getId().equals(clothes.getId()) : clothes.getId() != null) return false;
        return getCategory() != null ? getCategory().equals(clothes.getCategory()) : clothes.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }


    public void add(Clothes clothes) {
    }
}
