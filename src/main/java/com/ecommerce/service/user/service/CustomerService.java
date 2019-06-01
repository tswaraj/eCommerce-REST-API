package com.ecommerce.service.user.service;

import com.ecommerce.service.user.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.io.File;
import java.util.List;

@Component
public class CustomerService {
   // public static void main(String[] args) {




            public Customer createcustomer(Customer cust){
                SessionFactory factory = new Configuration()
                        .configure(new File("C:\\Users\\a0a031y\\Downloads\\service\\src\\main\\java\\com\\ecommerce\\service\\hibernate.cfg.xml"))
                        .addAnnotatedClass(Customer.class)
                        .buildSessionFactory();

                Session session = factory.getCurrentSession();

                System.out.println("creating a user");
                Customer temp = new Customer(cust.getUserame(), cust.getPassword(),cust.getEmail());
                session.beginTransaction();
                System.out.println("saving a user");
                session.save(temp);
                session.getTransaction().commit();
                System.out.println("done saving a user");
                return temp;
            }


//        }


        public Customer getcustomer ( int customerid){
            SessionFactory factory = new Configuration()
                    .configure(new File("C:\\Users\\a0a031y\\Downloads\\service\\src\\main\\java\\com\\ecommerce\\service\\hibernate.cfg.xml"))
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Customer mycust = session.get(Customer.class, customerid);

            System.out.println("complete....." + mycust);

            session.getTransaction().commit();
            System.out.println("done finally.............");
            System.out.println(mycust+"........");
            System.out.println(mycust.getClass().getName()+"........");
            return mycust;
        }

    public List<Customer> getallcust ( ){
        SessionFactory factory = new Configuration()
                .configure(new File("C:\\Users\\a0a031y\\Downloads\\service\\src\\main\\java\\com\\ecommerce\\service\\hibernate.cfg.xml"))
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Customer> mycust =session.createQuery("from Customer").getResultList();

        //System.out.println("complete....." + mycust);

        session.getTransaction().commit();
        System.out.println("done finally.............");
        //System.out.println(mycust+"........");
        System.out.println(mycust.getClass().getName()+"........");
        return mycust;
    }

    public void updatecustomer(Customer customer ,int cusid){
        SessionFactory factory = new Configuration()
                .configure(new File("C:\\Users\\a0a031y\\Downloads\\service\\src\\main\\java\\com\\ecommerce\\service\\hibernate.cfg.xml"))
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
//        Query query = session.createQuery("update Stu set email='foo@gmail.com'")
//                .executeUpdate();
        Customer mycust =session.get(Customer.class , cusid);
        mycust.setUserame(customer.getUserame());
        mycust.setEmail(customer.getEmail());
        mycust.setPassword(customer.getPassword());

        //System.out.println("complete....." + mycust);

        session.getTransaction().commit();
        System.out.println("done finally.............");

    }
}
