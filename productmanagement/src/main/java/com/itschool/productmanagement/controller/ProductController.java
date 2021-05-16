package com.itschool.productmanagement.controller;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.service.CategoryService;
import com.itschool.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String viewProducts(Model model){
        List<ProductModel> productModelList= productService.displayProducts();
        model.addAttribute("products", productModelList);
        return "produs";
    }

    @GetMapping(path="add-product")
    public String viewProductPage(Model model){
        model.addAttribute("newProduct", new ProductModel());
        List<CategoryModel> categories=categoryService.displayCategories();
        model.addAttribute("categories", categories);
                return"add-product";
    }

    @GetMapping(path = "product-add")
    public String addProduct(@ModelAttribute ProductModel productModel) {
        System.out.println("Add product ->" + productModel.getNumeProdus()+ " " + productModel.getDescriere()+" "+ productModel.getPret());
        productService.addProduct(productModel);
        return "redirect:/products";
    }

    @GetMapping(path = "edit-product")
    public String viewProductPage(@RequestParam int id, Model model) {
        ProductModel foundProduct = productService.findById(id);
        model.addAttribute("editProduct", foundProduct);
        return "product-edit";
    }

    @GetMapping(path="product-edit")
    public String editProduct(@ModelAttribute ProductModel editedProduct){
        productService.edit(editedProduct);
        return "redirect:/products";
    }

    @GetMapping(path = "deleteById")
    public String deleteById(@RequestParam("id") int id) {
        System.out.println("Deleting product with id:" + id);
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
