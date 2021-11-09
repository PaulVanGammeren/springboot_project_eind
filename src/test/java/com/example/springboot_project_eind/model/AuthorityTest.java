package com.example.springboot_project_eind.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorityTest {

    public Authority authority;

    @BeforeEach
    public void setUp(){
        this.authority = new Authority();
        this.authority.setUsername("paul");
        this.authority.setAuthority("admin");
    }

    @Test
    public void TestGetUsername(){
        String expectedUsername = "paul";
        String actualUsername = this.authority.getUsername();
        assertThat(actualUsername).isEqualTo(expectedUsername);
    }

    @Test
    public void TestGetAuthorities(){
        String exprectedAuth = "admin";
        String actualAuth = this.authority.getAuthority();
        assertThat(exprectedAuth).isEqualTo(actualAuth);
    }
}
