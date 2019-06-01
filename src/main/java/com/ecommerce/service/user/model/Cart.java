package com.ecommerce.service.user.model;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
    public Cart() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="custid")
    private int Custid;

    @Column(name="prodid")
    private int Prodid;

    public Cart(int custid, int prodid) {
        Custid = custid;
        Prodid = prodid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustid() {
        return Custid;
    }

    public void setCustid(int custid) {
        Custid = custid;
    }

    public int getProdid() {
        return Prodid;
    }

    public void setProdid(int prodid) {
        Prodid = prodid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", Custid=" + Custid +
                ", Prodid=" + Prodid +
                '}';
    }
}
