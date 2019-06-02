package com.eommerce.service.Admin.Controller;

import com.eommerce.service.Admin.DAO.SubcatProductService;
import com.eommerce.service.Admin.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubcatProductController {

    @Autowired
    private SubcatProductService service;

    @RequestMapping(value = "/categories/{id}/subcategories/{subcatid}/products",method = RequestMethod.GET)
    public List<Product> getProducts(@PathVariable int subcatid){
        return service.getProducts(subcatid);
    }

    @RequestMapping(value = "/categories/{id}/subcategories/{subcatid}/products",method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product, @PathVariable int subcatid){
        service.addProduct(product,subcatid);
    }

    @RequestMapping(value="/categories/{id}/subcategories/{subcatid}/products/{prodid}",method = RequestMethod.PUT)
    public void updateSubCat(@RequestBody Product product,@PathVariable int prodid){
        service.updateProduct(product,prodid);
    }

    @RequestMapping(value = "/categories/{id}/subcategories/{subcatid}/products/{prodid}",method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int prodid){
        service.deleteProduct(prodid);
    }


}
