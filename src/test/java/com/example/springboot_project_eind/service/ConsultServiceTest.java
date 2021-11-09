package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.model.Product;
import com.example.springboot_project_eind.repository.ConsultRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultServiceTest {

    @Mock
    ConsultRepository consultRepository;

    @InjectMocks
    ConsultService consultService;

    @Test
    public void getConsultTest() {

        Consult consult1 = new Consult();
        consult1.setAdvice("dit is advies 1");
        consult1.setId(1L);

        when(consultRepository.findById(1L)).thenReturn(Optional.of(consult1));
        var consult2 = consultService.findById(1L);

        assertThat(consult2.getAdvice()).isEqualTo("dit is advies 1");

    }

}




