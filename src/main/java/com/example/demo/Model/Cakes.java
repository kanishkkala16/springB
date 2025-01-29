package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "cakes")
public class Cakes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "flavour")
    private String flavour;
    @Column(name = "price")
    private Integer price;
    public Cakes(){

    }
    public Cakes(String name, String flavour, Integer price) {
        this.name = name;
        this.flavour = flavour;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
