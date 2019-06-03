package com.ecommerce.service.Admin.DAO;

import com.ecommerce.service.Admin.Model.Subcategory;
import com.ecommerce.service.Admin.Model.Category;
import com.ecommerce.service.Admin.Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class SubcatProductService {

    public List<Product> getProducts(int subcatid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Subcategory temp=session.get(Subcategory.class,subcatid);
        List<Product>products=temp.getProducts();
        for(Product p:products){
            System.out.println(p);
        }
        session.getTransaction().commit();
        factory.close();
        return products;
    }

    public void addProduct(Product product,int subcatid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Subcategory temp=session.get(Subcategory.class,subcatid);
        Product ptemp=new Product(product.getProdname(),product.getQty());
        temp.addProducts(ptemp);
        session.getTransaction().commit();
        factory.close();
    }

    public void updateProduct(Product product,int prodid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Product temp=session.get(Product.class,prodid);
        if(product.getProdname()!=null){
            temp.setProdname(product.getProdname());
        }
        if(product.getQty()!=0){
            temp.setQty(product.getQty());
        }
        session.getTransaction().commit();
    }

    public void deleteProduct(int prodid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Product temp=session.get(Product.class,prodid);
        session.delete(temp);
        session.getTransaction().commit();
    }
}
