package com.ecommerce.service.user.controller;

import com.ecommerce.service.user.model.Cart;
import com.ecommerce.service.user.model.Product;
import com.ecommerce.service.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/cart/cust/{custid}/prod/{prodid}")
    public Cart addcustomerproduct(@PathVariable int custid,@PathVariable int prodid)
    {
        return cartservice.addcart(custid,prodid);
    }

    @DeleteMapping("/cart/cust/{custid}/prod/{prodid}")
    public void deletecustprod(@PathVariable int custid,@PathVariable int prodid)
    {
         cartservice.deletecart(custid,prodid);
    }





}
