package com.ecommerce.service.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args){

        String jdbcUrl="jdbc:mysql://localhost:3306/storedb?useSSL=false&" +
                "serverTimezone=UTC";
        String user="root";
        String pass="amrit123";
        try{
            System.out.println("connecting to database : "+jdbcUrl);
            Connection myconn= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("connected successfully");
        }
        catch (Exception c){
            c.printStackTrace();
        }
    }
}
