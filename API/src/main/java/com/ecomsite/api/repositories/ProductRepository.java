package com.ecomsite.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomsite.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{

}
