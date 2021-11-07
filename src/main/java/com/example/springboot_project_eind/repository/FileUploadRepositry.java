package com.example.springboot_project_eind.repository;

import com.example.springboot_project_eind.model.FileUpload;
import org.springframework.data.repository.CrudRepository;

public interface FileUploadRepositry extends CrudRepository<FileUpload, Long> {
}
