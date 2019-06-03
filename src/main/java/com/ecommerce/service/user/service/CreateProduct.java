package com.ecommerce.service.user.service;

import com.ecommerce.service.user.model.Customer;
import com.ecommerce.service.user.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class CreateProduct {

    public  static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("creating a Product");
            Product temp = new Product(13000, "LG TV",1,567);
            session.beginTransaction();
            System.out.println("saving a product");
            session.save(temp);
            session.getTransaction().commit();
            System.out.println("done saving a product");
        }
        finally {
            factory.close();
        }

    }

}
