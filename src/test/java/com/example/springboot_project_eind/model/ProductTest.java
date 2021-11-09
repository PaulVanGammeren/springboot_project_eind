package com.example.springboot_project_eind.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    public Product product;

    @BeforeEach
    public void setUp(){
        this.product = new Product();
        this.product.setProductName("dagcreme");
        this.product.setPrice(12);
        this.product.setId(1L);
    }

    @Test
    public void testGetProduct(){
        String expectedProductName = "dagcreme";
        String actualProductName = this.product.getProductName();
        assertThat(actualProductName).isEqualTo(expectedProductName);
    }
    @Test
    public void testGetProductPrice(){
        int expectedProductPrice = 12;
        int actualProductPrice = this.product.getPrice();
        assertThat(actualProductPrice).isEqualTo(expectedProductPrice);
    }
    @Test
    public void testGetProductId(){
        long expectedProductId = 1L;
        long actualProductId = this.product.getId();
        assertThat(actualProductId).isEqualTo(expectedProductId);
    }


}
