package com.eommerce.service.Admin.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String catname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id")
    private List<Subcategory> subCategories;


    public List<Subcategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Subcategory> subCategories) {
        this.subCategories = subCategories;
    }

    public void addSubCategory(Subcategory temp){
        if(subCategories==null){
            subCategories=new ArrayList<>();
        }
        subCategories.add(temp);

    }
    public Category(){

    }

    public Category(String catname) {
        this.catname = catname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catname='" + catname + '\'' +
                '}';
    }
}
