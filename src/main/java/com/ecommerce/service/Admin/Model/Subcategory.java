package com.ecommerce.service.Admin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subcatname;

    public Subcategory(){

    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subcat_id")
    private List<Product> products;

    public void addProducts(Product temp){
        if(products==null){
            products=new ArrayList<>();
        }
        products.add(temp);

    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Subcategory(String subcatname) {
        this.subcatname = subcatname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", subcatname='" + subcatname + '\'' +
                '}';
    }
}
