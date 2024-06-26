package com.ecomsite.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomsite.api.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{

}
