package com.example.springboot_project_eind.model;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsultTest {

    public Consult consult;

    @BeforeEach
    public void setUp() {
        this.consult = new Consult();
        this.consult.setAdvice("dit is advies 1");
        this.consult.setId(1l);
    }

    @Test
    public void testGetConsult(){
        String expectedAdvies = "dit is advies 1";
        String actuallAdvies = this.consult.advice;
        assertThat(actuallAdvies).isEqualTo(expectedAdvies);
    }

    @Test
    public void testGetId(){
        Long expectedId = 1L;
        Long actuallId = this.consult.getId();
        assertThat(actuallId).isEqualTo(expectedId);
    }
}
