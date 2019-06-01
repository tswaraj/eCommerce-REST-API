package com.ecommerce.service.user.controller;

import com.ecommerce.service.user.model.Product;
import com.ecommerce.service.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartservice;

    @GetMapping("/cart/cust/{custid}")
    public List<Product> getcustomerproducts(@PathVariable int custid)
    {
        return cartservice.getcartprod(custid);
    }



}
