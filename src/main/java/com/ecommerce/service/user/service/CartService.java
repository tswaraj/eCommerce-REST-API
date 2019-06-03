package com.ecommerce.service.user.service;


import com.ecommerce.service.user.model.Cart;
import com.ecommerce.service.user.model.Customer;
import com.ecommerce.service.user.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.io.File;
import java.util.List;

@Component
public class CartService {

    public Cart addcart(int cid , int pid){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cart.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        System.out.println("creating a user");

        Cart temp = new Cart(cid,pid);
        session.beginTransaction();
        System.out.println("saving a user");
        session.save(temp);
        session.getTransaction().commit();
        System.out.println("done saving a user");
        return temp;
    }

    public void deletecart(int cid , int pid){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cart.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        System.out.println("Deleting a product from cart");


        session.beginTransaction();
        Query query= session.createQuery("delete from Cart c where c.Custid= :cids AND c.Prodid= :pids");
        query.setParameter("cids",cid);
        query.setParameter("pids",pid);

        query.executeUpdate();

        session.getTransaction().commit();
        System.out.println("done deleting a product from cart");

    }

    public List<Product> getcartprod(int userid){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        session.beginTransaction();

        Query query =session.createQuery("from Product p where " +
                 "p.id in (select c.Prodid from Cart c where c.Custid = :ids)");
        query.setParameter("ids",userid);

//        List<Cart> mycart= (List<Cart>)query.getResultList();
//        for(Cart c:mycart){
//            System.out.println(c.getProdid()+"..."+c.getCustid());
//        }

        List<Product>myprod=(List<Product>)query.getResultList();

        //=session.createQuery("from Product p where " +
//                "c.Custid = userid ").getResultList();
//
//        session.getTransaction().commit();
//        System.out.println("done saving a user");
        for(Product p:myprod){
            System.out.println(p.getProdname());
        }

        return myprod;
    }
    //in (select c.Prodid from Cart c where c.Custid = userid)
//    public static void main(String[] args){
//        CartService cs = new CartService();
//        cs.deletecart(1,2);
//    }

}
