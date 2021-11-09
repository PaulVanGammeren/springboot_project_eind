package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.model.Product;
import com.example.springboot_project_eind.repository.ProductRepository;
import com.example.springboot_project_eind.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void getProductTest() {

        Product product1 = new Product();
        product1.setProductName("dagcreme");
        product1.setPrice(12);
        product1.setId(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        var product2 = productService.findById(1L);

        assertThat(product2.getPrice()).isEqualTo(12);

    }




}
