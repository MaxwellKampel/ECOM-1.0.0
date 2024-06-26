package com.ecomsite.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomsite.api.models.Product;
import com.ecomsite.api.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepo;
	
//	Create
	public Product create(Product p) {
		return pRepo.save(p);
	}
	
//	Read All
	public List<Product> findall(){
		return pRepo.findAll();
	}
	
//	Read One
	public Product findOne(Long id) {
		Optional <Product> pp =  pRepo.findById(id);
		if(pp.isPresent()) {
			return pp.get();
		}else {
			return null;
		}
	}
	
//	Update One
	public Product update(Product p) {
		return pRepo.save(p);
	}
	
	public void delete (Long id) {
		pRepo.deleteById(id);
	}
}
