package com.example.springboot_project_eind.repository;


import com.example.springboot_project_eind.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
