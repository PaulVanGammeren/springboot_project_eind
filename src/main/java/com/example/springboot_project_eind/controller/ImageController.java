package com.example.springboot_project_eind.controller;

import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.model.Image;
import com.example.springboot_project_eind.service.ImageService;
import com.example.springboot_project_eind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")

public class ImageController {
    //connect Service to Controller
    @Autowired
    private ImageService imageService;
    private UserService userService;


    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    // get all Images from db
    @GetMapping(value = "/file-upload")
    public ResponseEntity<Collection<Image>> getAllFiles() {
        return ResponseEntity.ok().body(imageService.getAllFiles());
    }

    // find Image by Id from db
    @GetMapping(value = "/file-upload/{id}")
    public ResponseEntity getFileById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(imageService.getFileById(id));
    }

    // Upload an image to db
    @PostMapping(value = "/file-upload")
    public ResponseEntity<Object> upLoadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        Long newId = imageService.uploadFile(multipartFile);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).header("Access-Control-Expose-Headers", "Location").build();
    }

//    @PostMapping(value = "/consult/{username}")
//    public ResponseEntity addConsult(@PathVariable("username") String username, @RequestBody Consult consult) {
//        var consultId = consultService.save(consult);
//        userService.AssignConsultToUser(username, consultId);
//        return ResponseEntity.ok(consult);
//    }

    //replace an existing image
    @PutMapping(value = "/file-upload/{id}")
    public ResponseEntity<Object> updateFile(@PathVariable("id") long id, @RequestParam("file") MultipartFile newMultipartFile) throws IOException {
        imageService.updateFile(id, newMultipartFile);
        return ResponseEntity.noContent().build();
    }

    //delete movie
    @DeleteMapping(value = "/file-upload/{id}")
    public ResponseEntity<Object> deleteImage(@PathVariable("id") long id) {
        imageService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}


