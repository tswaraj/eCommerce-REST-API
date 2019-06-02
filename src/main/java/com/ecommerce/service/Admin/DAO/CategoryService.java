package com.ecommerce.service.Admin.DAO;

import com.ecommerce.service.Admin.Model.Category;
import com.ecommerce.service.Admin.Model.Product;
import com.ecommerce.service.Admin.Model.Subcategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CategoryService {

    public List<Category> getCategories(){
        SessionFactory factory=new Configuration().configure(new File("C:\\Users\\s0t01vk\\Documents\\Projects\\service\\src\\main\\java\\com\\ecommerce\\service\\Admin\\hibernate.cfg.xml")).addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
            session.beginTransaction();
            List<Category> categories=session.createQuery("from Category").getResultList();
            session.getTransaction().commit();
            factory.close();
        return categories;

    }

    public  void addCategory(Category category){
        SessionFactory factory=new Configuration().configure(new File("C:\\Users\\s0t01vk\\Documents\\Projects\\service\\src\\main\\java\\com\\ecommerce\\service\\Admin\\hibernate.cfg.xml")).addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Category temp=new Category(category.getCatname());
        session.save(temp);
        session.getTransaction().commit();
        factory.close();

    }

    public void updateCategory(Category category,int id){
        SessionFactory factory=new Configuration().configure(new File("C:\\Users\\s0t01vk\\Documents\\Projects\\service\\src\\main\\java\\com\\ecommerce\\service\\Admin\\hibernate.cfg.xml")).addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Category temp=session.get(Category.class,id);
        temp.setCatname(category.getCatname());
        session.save(temp);
        session.getTransaction().commit();
        factory.close();

    }

    public void deleteCategory(int id){
        SessionFactory factory=new Configuration().configure(new File("C:\\Users\\s0t01vk\\Documents\\Projects\\service\\src\\main\\java\\com\\ecommerce\\service\\Admin\\hibernate.cfg.xml")).addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Category temp=session.get(Category.class,id);
        //temp.setSubCategories(null);
        System.out.println(temp);
        session.delete(temp);
        session.getTransaction().commit();
        factory.close();

    }

}
