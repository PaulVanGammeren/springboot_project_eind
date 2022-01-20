//package com.example.springboot_project_eind.service;
//
//
//import com.example.springboot_project_eind.model.Image;
//import com.example.springboot_project_eind.repository.ImageRepository;
//import org.apache.tomcat.util.http.fileupload.FileUpload;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ImageServiceTest {
//
//    @Mock
//    ImageRepository imageRepository;
//
//    @InjectMocks
//    ImageService imageService;
//
//    @Test
//    public void getFileUploadTest(){
//
//        Image fileUpload1 = new Image();
//        fileUpload1.setFileName("foto.jpg");
//        fileUpload1.setId(1L);
//
//
//        when(imageRepository.findById(1L)).thenReturn(Optional.of(fileUpload1));var fileUpload2 = imageService.findById(1L);
//
//        assertThat(fileUpload2.getId()).isEqualTo(1L);
//
//
//
//
//    }
//    @Test
//    public void setFileNameTest(){
//       Image fileUpload1 = new Image();
//        fileUpload1.setFileName("foto.jpg");
//
//        fileUpload1.setId(1L);
//
//        String Expectedname = "foto.jpg";
//        String ActualName = fileUpload1.getFileName();
//
//
//    }
//
