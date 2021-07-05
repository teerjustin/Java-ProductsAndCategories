package com.example.ProductsAndCatagories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ProductsAndCatagories.models.Category;
import com.example.ProductsAndCatagories.models.Product;
import com.example.ProductsAndCatagories.services.CategoryService;
import com.example.ProductsAndCatagories.services.ProductService;


@Controller
public class MainController {
    private final ProductService productService;
    private final CategoryService categoryService;
    
    public MainController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    
	@GetMapping("/products")
    public String allProducts(Model model) {
        List<Product> products = productService.allProducts();
        model.addAttribute("products", products);
        System.out.println("I am home.");
        return "index.jsp";
    }
	
    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "NewProduct.jsp";
    }
    
	@GetMapping("/products/new")
    @RequestMapping(value="/products/new/create", method=RequestMethod.POST)
	  public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("I SHOULD BE CREATING A PRODUCT");
		if (result.hasErrors()) {
			return "redirect:/products";
		} else {
		    productService.createProduct(product);
		    return "redirect:/products";
		}
	}
    
	@RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, @ModelAttribute("category") Category c, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		//model.addAttribute("category", new Category());
		System.out.println("This is product: " + product.getName());
		System.out.println("This is category: " + categories.get(0).getName());
		System.out.println("This is category size: " + categories.size());
		
		return "ShowProduct.jsp";
    }
	
	
	@RequestMapping(value="/products/{pid}", method=RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("pid") String pid, @Valid @ModelAttribute("category") Category c, BindingResult result) {
		System.out.println(pid);
		System.out.println(c);
		Long stringToLongPid = Long.valueOf(pid);
		Product product = productService.findProduct(stringToLongPid);

		Category category = categoryService.findCategory(c.getId());
		System.out.println("This is my category's name: " + category.getName());
		
		productService.addCategory(stringToLongPid, category);

		
		System.out.println("Category Id: " + category.getId());
		System.out.println("I AM IN ADD CATEGORY HANDLER");
		return "redirect:/products/{pid}";
	}
	


	@GetMapping("/categories")
    public String allCategories(Model model) {
        List<Category> categories = categoryService.allCategories();
        model.addAttribute("categories", categories);
        System.out.println("I am in category home.");
        return "CategoryHome.jsp";
    }
	
	@RequestMapping("/categories/new")
	 public String newCategory(@ModelAttribute("category") Category category, Model model) {
		List<Category> categories = categoryService.allCategories();
	    model.addAttribute("categories", categories);
	    return "NewCategory.jsp";
	}
	
	
    @RequestMapping(value="/categories/new/create", method=RequestMethod.POST)
	  public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		System.out.println("I SHOULD BE CREATING A CATEGORY");
		if (result.hasErrors()) {
			System.out.println("THERE IS AN ERROR CREATING A CATEGORY");
			System.out.println(result.getAllErrors());
			return "redirect:/categories";
		} else {
		    categoryService.createCategory(category);
		    System.out.println("REDIRECTING BACK HOME, NINJA SHOULD BE CREATED");
		    return "redirect:/categories";
		}
	}
	
	@RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long id, @ModelAttribute("product") Product p, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		model.addAttribute("category", category);
		return "ShowCategory.jsp";
    }

	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String addProductToCategory(@PathVariable("id") String id, @Valid @ModelAttribute("product") Product p, BindingResult result) {
		System.out.println(id);
		System.out.println(p);
		Long stringToLongId = Long.valueOf(id);
		Category category = categoryService.findCategory(stringToLongId);

		Product product = productService.findProduct(p.getId());

		
		categoryService.addProduct(stringToLongId, product);

		

		return "redirect:/categories/{id}";
	}
}
