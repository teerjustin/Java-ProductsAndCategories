package com.example.ProductsAndCatagories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductsAndCatagories.models.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
}
