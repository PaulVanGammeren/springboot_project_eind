package com.example.springboot_project_eind.repository;


import com.example.springboot_project_eind.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
