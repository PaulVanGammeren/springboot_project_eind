package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.FileUpload;
import com.example.springboot_project_eind.repository.FileUploadRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepositry repository;

    public Iterable<FileUpload> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(MultipartFile file) {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        FileUpload newFileToStore = new FileUpload();
        newFileToStore.setFileName(originalFilename);

        FileUpload storedFile = repository.save(newFileToStore);

        return storedFile.getId();
    }

    public void deleteFile(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        repository.deleteById(id);
    }

    public Optional<FileUpload> getFileById(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        return repository.findById(id);
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

}