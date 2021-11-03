package com.example.springboot_project_eind.controller;


import com.example.springboot_project_eind.exceptions.BadRequestException;
import com.example.springboot_project_eind.model.User;
import com.example.springboot_project_eind.payload.request.UserPostRequest;
import com.example.springboot_project_eind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
      @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@RequestBody UserPostRequest userPostRequest) {

        String newUsername = userService.createUser(userPostRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

//    @PutMapping(value = "/{username}")
//    public ResponseEntity<Object> updateCustomer(@PathVariable("username") String username, @RequestBody User user) {
//        userService.updateUser(username, user);
//        return ResponseEntity.noContent().build();
//    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{username}/password")
    public ResponseEntity<Object> setPassword(@PathVariable("username") String username, @RequestBody String password) {
        userService.setPassword(username, password);
        return ResponseEntity.noContent().build();
    }

}