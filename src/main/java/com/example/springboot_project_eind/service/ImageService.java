package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.model.Image;
import com.example.springboot_project_eind.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class ImageService {


    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Long uploadFile(MultipartFile multipartFile, String username) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        Image image = new Image(fileName, multipartFile.getContentType(), multipartFile.getBytes());
        image.setUsername(username);
        imageRepository.save(image);
        return image.getId();
    }

    public Optional<Image> getFileById(Long id){
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        return imageRepository.findById(id);
    }

//    public Optional<Image> getFileByUsername(String username){
//        if (!imageRepository.existsByUSername(username)) throw new RecordNotFoundException();
//        return imageRepository.findByUsername(username);
//    }

    public Collection<Image> getAllFiles(){
        return imageRepository.findAll();
    }



    //update an existing file
    public void updateFile(long id, MultipartFile newMultipartFile) throws IOException {
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        Image image = imageRepository.findById(id).get();
        image.setFileName(newMultipartFile.getOriginalFilename());
        image.setType(newMultipartFile.getContentType());
        image.setFile(newMultipartFile.getBytes());
        imageRepository.save(image);
    }

    //delete an existing file
    public void deleteFile(long id)  {
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        imageRepository.deleteById(id);
    }

    public Long save(Image image) {
        var newImage =imageRepository.save(image);
        return newImage.getId();
    }



}

