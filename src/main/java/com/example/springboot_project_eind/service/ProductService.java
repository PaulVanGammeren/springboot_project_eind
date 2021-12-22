package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.Product;
import com.example.springboot_project_eind.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public Iterable<Product> findAll() {
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    public Product findById(long nr) {
        Optional<Product> product = productRepository.findById(nr);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("Product with id " + nr + " not found");
        }
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long nr) {
        try {
            productRepository.deleteById(nr);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }


    }
}
