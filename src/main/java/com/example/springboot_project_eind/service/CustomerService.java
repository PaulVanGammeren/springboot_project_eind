package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.Customer;
import com.example.springboot_project_eind.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

@Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Iterable<Customer> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        return customers;
    }


    public void deleteById(long nr) {
        try {
            customerRepository.deleteById(nr);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

    public Optional<Customer> findById(long nr) {
        try {
            Optional<Customer> customer = customerRepository.findById(nr);
            return customer;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    public void updateCustomer(long nr, Customer newCustomer) {
    if (!customerRepository.existsById(nr)) {
        throw new RecordNotFoundException();
        }
    Customer customer = customerRepository.findById(nr).get();
    customer.setFirstName(newCustomer.getFirstName());
    customer.setLastName(newCustomer.getLastName());
    customerRepository.save(customer);
    }


    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    public Collection<Customer> getAllCustomers() {
        return (Collection<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerByLastName(String name) {
        return customerRepository.findByLastName(name);
    }
}
