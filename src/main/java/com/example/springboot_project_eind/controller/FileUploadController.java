package com.example.springboot_project_eind.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("file-upload")
@CrossOrigin
public class FileUploadController {

    @GetMapping
    public ResponseEntity<Object> getFiles() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id/file")
    public ResponseEntity<Object> getFileData(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> uploadFile() {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFile() {
        return ResponseEntity.noContent().build();
    }

}