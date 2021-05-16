package com.itschool.productmanagement.controller;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String viewCategories(Model model){
        List<CategoryModel> categoryModelList= categoryService.displayCategories();
        model.addAttribute("categories", categoryModelList);
        return "categorie";
    }

    @GetMapping(path="add-category")
    public String viewCategoryPage(Model model){
        model.addAttribute("newCategory", new CategoryModel());
        return"add-category";
    }

    @GetMapping(path = "category-add")
    public String addCategory(@ModelAttribute CategoryModel categoryModel) {
        System.out.println("Add category ->" + categoryModel.getNume());
        categoryService.addCategory(categoryModel);
        return "redirect:/categories";
    }

    @GetMapping(path = "edit-category")
    public String viewCategoryPage(@RequestParam int id, Model model) {
        CategoryModel foundCategory = categoryService.findById(id);
        model.addAttribute("editCategory", foundCategory);
        return "category-edit";
    }

    @GetMapping(path="category-edit")
    public String editCategory(@ModelAttribute CategoryModel editedCategory){
        categoryService.edit(editedCategory);
        return "redirect:/categories";
    }

    @GetMapping(path = "deleteCategoryById")
    public String deleteCategoryById(@RequestParam("id") int id) {
        System.out.println("Deleting category with id:" + id);
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }



}
