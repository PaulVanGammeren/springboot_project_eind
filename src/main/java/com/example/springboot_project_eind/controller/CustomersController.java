package com.example.springboot_project_eind.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController {

    private static List<String>  customers = new ArrayList<>();

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomers(){
        return ResponseEntity.ok(customers);
    }
    @GetMapping(value = "/customers/{nr}")
    public ResponseEntity getCustomer(@PathVariable int nr) {
        return ResponseEntity.ok(customers.get(nr));
    }
    @PostMapping(value ="/customers")
    public ResponseEntity addCustomer(@RequestBody String customer) {
        customers.add(customer);
        return ResponseEntity.ok("Created");
    }
    @DeleteMapping(value = "/customers/{nr}")
    public ResponseEntity deleteCustomer(@PathVariable int nr) {
        customers.remove(nr);
        return ResponseEntity.ok("verwijderd");
    }
    @PutMapping(value = "/customer/{nr}")
    public ResponseEntity updateCustomer(@PathVariable int nr, @RequestBody String customer) {
        customers.add(nr, customer);
        return ResponseEntity.ok("Updated");
    }
}
