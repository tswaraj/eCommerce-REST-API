package com.ecommerce.service.user.controller;


import com.ecommerce.service.user.model.Customer;
import com.ecommerce.service.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @GetMapping("/customers/{customerid}")
        public Customer getonecustomer(@PathVariable int customerid){


           return (Customer) customerservice.getcustomer(customerid);
        //return new Customer("abc","sdskd","as@gmail.com");
        }

    @PostMapping("/customers")
    public Customer createonecustomer(@RequestBody Customer customer){


        return  customerservice.createcustomer(customer);
        //return new Customer("abc","sdskd","as@gmail.com");
    }

    @GetMapping("/customers")
    public List<Customer> getallcustomers(){


        return  customerservice.getallcust();
        //return new Customer("abc","sdskd","as@gmail.com");
    }



}
