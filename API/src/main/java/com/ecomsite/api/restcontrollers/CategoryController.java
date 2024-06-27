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

import com.ecomsite.api.models.Category;
import com.ecomsite.api.repositories.CategoryRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost://5173", allowCredentials = "true")
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository cRepo;

//	All Categories
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> allCategories() {
		return ResponseEntity.ok().body(cRepo.findAll());
	}

//	@GetMapping("/categories")
//	public ResponseEntity <Object> allProducts(){
//		return ResponseEntity.ok().body(cRepo.findAll());
//	}

//	Create Category
	@PostMapping("/categories")
	public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category, 
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		}
		Category newProduct = cRepo.save(category);
		return ResponseEntity.ok().body(newProduct);
	}

//	One Category
	@GetMapping("/categories/${id}")
	public Category oneCategory(@PathVariable ("id") Long id) {
		return cRepo.findById(id).orElseThrow(RuntimeException::new);
	}

//	Update Category
	@PutMapping("/categories/${id}")
	public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, 
			@Valid @RequestBody Category category,
			BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		}
		Category updatedProduct = cRepo.save(category);
		return ResponseEntity.ok().body(updatedProduct);
	}
	
	@DeleteMapping("/categories/${id}")
	public ResponseEntity <Object> deleteCategory(@PathVariable("id") Long id){
		cRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}

}



