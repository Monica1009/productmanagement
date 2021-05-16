package com.itschool.productmanagement.repository;

import com.itschool.productmanagement.entities.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {


}
