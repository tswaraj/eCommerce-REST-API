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
public class CatSubcatService {

    public List<Subcategory> getSubcat(int id){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Category temp=session.get(Category.class,id);
        List<Subcategory> subcategories=temp.getSubCategories();
        //doubt:if we remove sout GET request will not be executed
        for(Subcategory s:subcategories){
            System.out.println(s);
        }
        session.getTransaction().commit();
        factory.close();
        return subcategories;
    }

    public void addSubCat(Subcategory subcategory,int id){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Subcategory subtemp=new Subcategory(subcategory.getSubcatname());
        Category temp=session.get(Category.class,id);
        temp.addSubCategory(subtemp);
        session.getTransaction().commit();
        factory.close();
    }

    public void deleteSubCat(int subcatid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Subcategory temp=session.get(Subcategory.class,subcatid);
        session.delete(temp);
        session.getTransaction().commit();
        factory.close();
    }

    public  void updateSubCat(Subcategory subcategory,int subcatid){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Subcategory temp =session.get(Subcategory.class,subcatid);
        if(subcategory.getSubcatname()!=null){
            temp.setSubcatname(subcategory.getSubcatname());
        }
        session.getTransaction().commit();
        factory.close();
    }
}
