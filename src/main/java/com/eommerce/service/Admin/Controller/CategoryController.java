package com.eommerce.service.Admin.Controller;

import com.eommerce.service.Admin.DAO.CategoryService;
import com.eommerce.service.Admin.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService tempCategoryService;

    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public List<Category> getCategories() {
        return tempCategoryService.getCategories();
    }

    @RequestMapping(value = "/categories",method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category){
        tempCategoryService.addCategory(category);
    }

    @RequestMapping(value = "/categories/{id}",method = RequestMethod.PUT)
    public void updateCategory(@RequestBody Category category,@PathVariable int id){
        tempCategoryService.updateCategory(category,id);
    }

    @RequestMapping(value = "/categories/{id}",method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable int id){
        tempCategoryService.deleteCategory(id);
    }

}
