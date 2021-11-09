package com.example.springboot_project_eind.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    public User user;

    @BeforeEach
    public void setUp(){
        this.user = new User();
        this.user.setUsername("paul");
        this.user.setEmail("paul@gmail.com");
        this.user.setPassword("password");
    }

    @Test
    public void testGetUsername(){
        String expectedUsername = "paul";
        String actualUsername = this.user.getUsername();
        assertThat(actualUsername).isEqualTo(expectedUsername);
    }
    @Test
    public void testGetEmail() {
        String expectedEmail = "paul@gmail.com";
        String actualEmail = this.user.getEmail();
        assertThat(actualEmail).isEqualTo(expectedEmail);
    }
    @Test
    public void testGetPassword() {
        String expectedPassword = "password";
        String actualPassword = this.user.getPassword();
        assertThat(actualPassword).isEqualTo(expectedPassword);
    }


}
