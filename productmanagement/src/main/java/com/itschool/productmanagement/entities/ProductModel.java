package com.itschool.productmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String numeProdus;
    private String descriere;
    private int pret;

    @ManyToOne
    private CategoryModel category;

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
