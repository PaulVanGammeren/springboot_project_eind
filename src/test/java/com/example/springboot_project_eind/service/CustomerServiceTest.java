package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.model.Customer;
import com.example.springboot_project_eind.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test

    public void getCustomdfTest() {
        //create user
        Customer customer1 = new Customer();
        customer1.setId(2L);
        customer1.setFirstName("paul");
        customer1.setLastName("van Gammeren");
        customer1.seteMail("paul@gmail.com");


        //when
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));
        var customer2 = customerService.findById(1L);


        assertThat(customer2.get().getId()).isEqualTo(2L);


    }

}
