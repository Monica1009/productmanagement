package com.itschool.productmanagement.service;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> displayCategories(){
        List<CategoryModel> categoryModelList= categoryRepository.findAll();
        return categoryModelList;
    }

    public void addCategory(CategoryModel categoryModel){
        categoryRepository.save(categoryModel);
    }

    public CategoryModel findById(int id){
        Optional<CategoryModel> optionalCategoryModel = categoryRepository.findById(id);
        return optionalCategoryModel.get();
    }

    public void edit(CategoryModel editedCategory) {
        categoryRepository.save(editedCategory);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

}
