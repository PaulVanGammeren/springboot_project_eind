package com.example.springboot_project_eind.repository;

import com.example.springboot_project_eind.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


    Customer findByLastName(String name);
}
