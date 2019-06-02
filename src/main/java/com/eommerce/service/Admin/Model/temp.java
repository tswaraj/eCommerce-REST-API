package com.eommerce.service.Admin.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class temp {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure(new File("C:\\Users\\s0t01vk\\Documents\\Projects\\service\\src\\main\\java\\com\\eommerce\\service\\hibernate.cfg.xml")).addAnnotatedClass(Category.class).addAnnotatedClass(Subcategory.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();
            //Category tempCategory=new Category("Stationaries");
            //session.save(tempCategory);
           //Category tempCategory=session.get(Category.class,1);// tempCategory.addSubCategory(new Subcategory("Pens"));
           // tempCategory.addSubCategory(new Subcategory("Books"));
           // List<Category> categories=new ArrayList<Category>();
            //categories= (List<Category>) session.createQuery("from Category ").getResultList();
            //for(Category c:categories){
              //  System.out.println(c);
            //}
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
