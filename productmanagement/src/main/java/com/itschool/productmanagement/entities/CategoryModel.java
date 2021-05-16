package com.itschool.productmanagement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categorie")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


}

