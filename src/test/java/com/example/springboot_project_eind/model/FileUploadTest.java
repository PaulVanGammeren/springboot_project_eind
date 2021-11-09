package com.example.springboot_project_eind.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class FileUploadTest {
    public FileUpload fileUpload;

    @BeforeEach
    public void setUp() {
        this.fileUpload = new FileUpload();
        this.fileUpload.setFileName("foto.jpg");
        this.fileUpload.setDescription("mooie foto");
        this.fileUpload.setTitle("selfie");
    }
    @Test
    public void testGetFileName(){
        String expectedFileName = "foto.jpg";
        String actualFileName = this.fileUpload.getFileName();
        assertThat(expectedFileName).isEqualTo(actualFileName);
    }

    @Test
    public void testGetDescription(){
        String expectedDescription = "mooie foto";
        String actualDescription = this.fileUpload.getDescription();
        assertThat(expectedDescription).isEqualTo(actualDescription);
    }

    @Test
    public void testGetTitle(){
        String expectedTitle = "selfie";
        String actualTitle = this.fileUpload.getTitle();
        assertThat(expectedTitle).isEqualTo(actualTitle);
    }
}
