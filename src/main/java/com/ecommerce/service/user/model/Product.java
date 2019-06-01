package com.ecommerce.service.user.model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    public Product(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private int Price;

    @Column(name="prodname")
    private String Prodname;

    @Column(name="qty")
    private int Qty;

    @Column(name="subcat_id")
    private int Subcat_id;

    public Product(int price, String prodname, int qty, int subcat_id) {
        Price = price;
        Prodname = prodname;
        Qty = qty;
        Subcat_id = subcat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getProdname() {
        return Prodname;
    }

    public void setProdname(String prodname) {
        Prodname = prodname;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public int getSubcat_id() {
        return Subcat_id;
    }

    public void setSubcat_id(int subcat_id) {
        Subcat_id = subcat_id;
    }
}

