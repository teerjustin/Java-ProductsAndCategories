package com.example.ProductsAndCatagories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.ProductsAndCatagories.models.Category;
import com.example.ProductsAndCatagories.models.Product;
import com.example.ProductsAndCatagories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	//get all categories
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
	
	
	//create category
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}
	
    // retrieves a category
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
	public Category addProduct(Long id, Product p) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		Category myCategory = categoryOptional.get();
		List<Product> myProducts = myCategory.getProducts();

		if (!myProducts.contains(p)) {
			myProducts.add(p);
		}

		myCategory.setProducts(myProducts);
		return categoryRepository.save(myCategory);
	}
}
