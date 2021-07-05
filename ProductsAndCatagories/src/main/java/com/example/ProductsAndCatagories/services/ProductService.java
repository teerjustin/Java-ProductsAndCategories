package com.example.ProductsAndCatagories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ProductsAndCatagories.models.Category;
import com.example.ProductsAndCatagories.models.Product;
import com.example.ProductsAndCatagories.repositories.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    // returns all the products
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    // creates a product
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
    
	//update product name...
	public Product updateProduct(Long id, String name) {
		Optional<Product> product = productRepository.findById(id);
		Product b = product.get();
		b.setName(name);
		return productRepository.save(b);
	}
	
	public Product addCategory(Long id, Category c) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product myProduct = productOptional.get();
		List<Category> myCategories = myProduct.getCategories();
		if (!myCategories.contains(c)) {
			myCategories.add(c);
		}
		System.out.println(myCategories);
		myProduct.setCategories(myCategories);
		return productRepository.save(myProduct);
	}
   
    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
}
