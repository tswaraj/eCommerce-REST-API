package com.ecommerce.service.Admin.Controller;

import com.ecommerce.service.Admin.DAO.CatSubcatService;
import com.ecommerce.service.Admin.Model.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatSubcatController {

    @Autowired
    private CatSubcatService service;

    @RequestMapping(value = "/categories/{id}/subcategories",method = RequestMethod.GET)
    public List<Subcategory> getSubcst(@PathVariable int id){
        return service.getSubcat(id);
    }

    @RequestMapping(value = "/categories/{id}/subcategories",method = RequestMethod.POST)
    public void addSubcat(@RequestBody Subcategory subcategory, @PathVariable int id){
        service.addSubCat(subcategory,id);
    }

    @RequestMapping(value="/categories/{id}/subcategories/{subcatid}",method = RequestMethod.PUT)
    public void updateSubCat(@RequestBody Subcategory subcategory,@PathVariable int subcatid){
        service.updateSubCat(subcategory,subcatid);
    }

    @RequestMapping(value = "/categories/{id}/subcategories/{subcatid}",method=RequestMethod.DELETE)
    public void deleteSubCat(@PathVariable int subcatid){
        service.deleteSubCat(subcatid);
    }
}
