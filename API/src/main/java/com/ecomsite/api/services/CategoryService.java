package com.ecomsite.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomsite.api.models.Category;
import com.ecomsite.api.repositories.CategoryRepository;

//!!!!! Not In Use!!!!
//!!!!! This file is currently not in use, but retained for potential use in the future!!!!

public class CategoryService {

	@Autowired
	private CategoryRepository cRepo;

//	Create
	public Category create(Category c) {
		return cRepo.save(c);
	}

//	Read All
	public List<Category> findall() {
		return cRepo.findAll();
	}

//	Read One
	public Category findOne(Long id) {
		Optional<Category> cc = cRepo.findById(id);
		if (cc.isPresent()) {
			return cc.get();
		} else {
			return null;
		}
	}

//	Update One
	public Category update(Category c) {
		return cRepo.save(c);
	}

	public void delete(Long id) {
		cRepo.deleteById(id);
	}
}
