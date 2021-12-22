package com.example.springboot_project_eind.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ImageTest {
    public Image fileUpload;

    @BeforeEach
    public void setUp() {
        this.fileUpload = new Image();
        this.fileUpload.setFileName("foto.jpg");
    }
    @Test
    public void testGetFileName(){
        String expectedFileName = "foto.jpg";
        String actualFileName = this.fileUpload.getFileName();
        assertThat(expectedFileName).isEqualTo(actualFileName);
    }


}
