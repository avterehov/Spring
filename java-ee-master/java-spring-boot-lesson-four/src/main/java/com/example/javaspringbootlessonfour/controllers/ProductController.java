package com.example.javaspringbootlessonfour.controllers;


import com.example.javaspringbootlessonfour.entities.Product;
import com.example.javaspringbootlessonfour.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public String indexPage(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "product_views/index";
	}

	@GetMapping("/{id}")
	public String editProduct(@PathVariable(value = "id") Long id,
	                          Model model) {
		model.addAttribute("product", productRepository.findById(id));
		return "product_views/product_form";
	}

	@PostMapping("/product_update")
	public String updateProduct(Product product) {

		if (product.getId() == null){
		productRepository.add(product);
		}else {
			productRepository.update(product);
		}
		return "redirect:/product";
	}

	@GetMapping("/new")
	public String newProduct (Model model) {
		model.addAttribute(new Product());
		return "product_views/product_form";
	}


	@GetMapping("/delete/{id}")
	public String removeProduct(@PathVariable(value = "id") Long id) {
	productRepository.remove(id);
	return "redirect:/product";
	}
}
