package com.ecommerce.service.user.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    public Customer(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String Username;

    @Column(name="password")
    private String Password;

    @Column(name="email")
    private String Email;

    public Customer(String username, String password, String email) {
        Username = username;
        Password = password;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserame() {
        return Username;
    }

    public void setUserame(String userame) {
        Username = userame;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
