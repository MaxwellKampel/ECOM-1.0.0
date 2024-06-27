package com.ecomsite.api.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomsite.api.models.Product;
import com.ecomsite.api.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository pRepo;

//	All Products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> allProducts() {
		return ResponseEntity.ok().body(pRepo.findAll());
	}

//	@GetMapping("/products")
//	public ResponseEntity <Object> allProducts(){
//		return ResponseEntity.ok().body(pRepo.findAll());
//	}

//	Create Product
	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		}
		Product newProduct = pRepo.save(product);
		return ResponseEntity.ok().body(newProduct);
	}

//	One Product
	@GetMapping("/products/{id}")
	public Product oneProduct(@PathVariable("id") Long id) {
		return pRepo.findById(id).orElseThrow(RuntimeException::new);
	}

//	Update Product
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, 
			@Valid @RequestBody Product product,
			BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		}
		Product updatedProduct = pRepo.save(product);
		return ResponseEntity.ok().body(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity <Object> deleteProduct(@PathVariable("id") Long id){
		pRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
