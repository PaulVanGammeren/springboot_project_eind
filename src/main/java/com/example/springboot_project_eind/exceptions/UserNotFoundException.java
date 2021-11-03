package com.example.springboot_project_eind.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("Cannot find specified user.");
    }

}
