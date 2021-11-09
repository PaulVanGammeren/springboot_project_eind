package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.model.FileUpload;
import com.example.springboot_project_eind.repository.FileUploadRepositry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FileUploadServiceTest {

    @Mock
    FileUploadRepositry fileUploadRepositry;

    @InjectMocks
    FileUploadService fileUploadService;

    @Test
    public void getFileUploadTest(){

        FileUpload fileUpload1 = new FileUpload();
        fileUpload1.setFileName("foto.jpg");
        fileUpload1.setTitle("mooie foto");
        fileUpload1.setDescription("selfie");
        fileUpload1.setId(1L);


        when(fileUploadRepositry.findById(1L)).thenReturn(Optional.of(fileUpload1));
        var fileUpload2 = fileUploadService.findById(1L);

        assertThat(fileUpload2.getId()).isEqualTo(1L);




    }
//    @Test
//    public void setFileNameTest(){
//        FileUpload fileUpload1 = new FileUpload();
//        fileUpload1.setFileName("foto.jpg");
//        fileUpload1.setTitle("mooie foto");
//        fileUpload1.setDescription("selfie");
//        fileUpload1.setId(1L);
//
//        String Expectedname = "foto.jpg";
//        String ActualName = fileUpload1.getFileName();
//
//        assertThat(Expectedname).IsEqualTo(ActualName);
//
//    }
}
