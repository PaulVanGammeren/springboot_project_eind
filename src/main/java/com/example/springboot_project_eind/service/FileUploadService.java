package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.FileUpload;
import com.example.springboot_project_eind.model.Product;
import com.example.springboot_project_eind.repository.FileUploadRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class FileUploadService {



    @Autowired
    public FileUploadRepositry fileUploadRepositry;



        public long uploadFile(MultipartFile file) {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        FileUpload newFileToStore = new FileUpload();
        newFileToStore.setFileName(originalFilename);

        FileUpload storedFile = fileUploadRepositry.save(newFileToStore);

        return storedFile.getId();
    }

    public void deleteFile(long id) {
        if (!fileUploadRepositry.existsById(id)) throw new RecordNotFoundException();
        fileUploadRepositry.deleteById(id);
    }

    public Optional<FileUpload> getFileById(long id) {
        if (!fileUploadRepositry.existsById(id)) throw new RecordNotFoundException();
        return fileUploadRepositry.findById(id);
    }

    public boolean fileExistsById(long id) {
        return fileUploadRepositry.existsById(id);
    }

    public FileUpload findById(long l) {
        Optional<FileUpload> fileUpload = fileUploadRepositry.findById(1L);
        if (fileUpload.isPresent()) {
            return fileUpload.get();
        } else {
            throw new RecordNotFoundException("Product with id  not found");
        }
    }

}