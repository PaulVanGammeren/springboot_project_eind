package com.example.springboot_project_eind.controller;

import com.example.springboot_project_eind.exceptions.BadRequestException;
import com.example.springboot_project_eind.exceptions.ForbiddenException;
import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception(BadRequestException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<Object> exception(ForbiddenException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }



}
