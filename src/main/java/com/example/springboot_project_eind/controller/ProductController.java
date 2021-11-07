package com.example.springboot_project_eind.controller;


import com.example.springboot_project_eind.model.Product;
import com.example.springboot_project_eind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService; }

    @GetMapping(value = "/products")
    public ResponseEntity getProducts(){
        Iterable<Product> products;
        products = productService.findAll();
        return ResponseEntity.ok(products);
    }
    @GetMapping(value = "/products/{nr}")
    public ResponseEntity getProduct(@PathVariable long nr) {
        Product product = productService.findById(nr);
        return ResponseEntity.ok(product);
    }
    @PostMapping(value = "/products")
    public ResponseEntity addSpeler(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/products/{nr}")
    public ResponseEntity deleteProduct(@PathVariable long nr) {
        productService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/products/{nr}")
    public ResponseEntity updateProduct(@PathVariable long nr, @RequestBody Product product) {
        return ResponseEntity.ok("Aangepast");
    }

}
