package com.example.springboot_project_eind.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    public Customer customer;

    @BeforeEach
    public void setUp(){
        this.customer = new Customer("paul", "van Gammeren");
        this.customer.seteMail("paul@gmail.com");
    }
    @Test
    public void testGetFullName(){
        String expectedFullName = "paul van Gammeren";
        String actualFullName = this.customer.getFullName();
        assertThat(actualFullName).isEqualTo(expectedFullName);
    }
    @Test
    public void testGetEmail(){
        String expectedEMail = "paul@gmail.com";
        String actualEmail = this.customer.geteMail();
        assertThat(actualEmail).isEqualTo(expectedEMail);
    }
}
