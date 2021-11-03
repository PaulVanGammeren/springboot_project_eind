package com.example.springboot_project_eind.controller;


import com.example.springboot_project_eind.exceptions.UserNotFoundException;
import com.example.springboot_project_eind.model.Customer;
import com.example.springboot_project_eind.repository.CustomerRepository;
import com.example.springboot_project_eind.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CustomersController {



    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomers() {
        Iterable <Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
        }


    @GetMapping(value = "/customers/{nr}")
    public ResponseEntity getCustomer(@PathVariable long nr) {
            Optional<Customer> customer = customerService.findById(nr);
            return ResponseEntity.ok(customer);
    }
    @PostMapping(value ="/customers")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/customers/{id}" )
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(value = "/customers/{nr}")
    public ResponseEntity deleteCustomer(@PathVariable long nr) {
        customerService.deleteById(nr);
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping(value = "/customer/{nr}")
    public ResponseEntity updateCustomer(@PathVariable long nr, @RequestBody Customer customer) {
        customerService.updateCustomer(nr, customer);
        return ResponseEntity.noContent().build();
    }
}
