package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.exceptions.BadRequestException;
import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.exceptions.UserNotFoundException;
import com.example.springboot_project_eind.model.Authority;
import com.example.springboot_project_eind.model.Image;
import com.example.springboot_project_eind.model.User;
import com.example.springboot_project_eind.payload.request.UserPostRequest;
import com.example.springboot_project_eind.repository.ConsultRepository;
import com.example.springboot_project_eind.repository.ImageRepository;
import com.example.springboot_project_eind.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private ConsultRepository consultRepository;
    private ImageService imageService;
    private ImageRepository imageRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ConsultRepository consultRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.consultRepository = consultRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    public Iterable <User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username)
    {
        return userRepository.findById(username);
    }



    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserPostRequest userPostRequest) {
        try {
            String encryptedPassword = passwordEncoder.encode(userPostRequest.getPassword());

            User user = new User();
            user.setUsername(userPostRequest.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(userPostRequest.getEmail());
            user.setEnabled(true);
            user.addAuthority("ROLE_USER");

            User newUser = userRepository.save(user);
            return newUser.getUsername();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }

    }

    public void deleteUser(String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
        }
        else {
            throw new UserNotFoundException();
        }
    }

    public void updateUser(String username, User newUser) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        else {
            User user = userOptional.get();
            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setEmail(newUser.getEmail());
            user.setEnabled(newUser.isEnabled());
            userRepository.save(user);
        }
    }

    public Set<Authority> getAuthorities(String username) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        else {
            User user = userOptional.get();
            return user.getAuthorities();
        }
    }

    public void addAuthority(String username, String authorityString) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        else {
            User user = userOptional.get();
            user.addAuthority(authorityString);
            userRepository.save(user);
        }
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).orElse(null);
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().orElse(null);
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }


    private boolean isValidPassword(String password) {
        final int MIN_LENGTH = 8;
        final int MIN_DIGITS = 1;
        final int MIN_LOWER = 1;
        final int MIN_UPPER = 1;
        final int MIN_SPECIAL = 1;
        final String SPECIAL_CHARS = "@#$%&*!()+=-_";

        long countDigit = password.chars().filter(ch -> ch >= '0' && ch <= '9').count();
        long countLower = password.chars().filter(ch -> ch >= 'a' && ch <= 'z').count();
        long countUpper = password.chars().filter(ch -> ch >= 'A' && ch <= 'Z').count();
        long countSpecial = password.chars().filter(ch -> SPECIAL_CHARS.indexOf(ch) >= 0).count();

        boolean validPassword = true;
        if (password.length() < MIN_LENGTH) validPassword = false;
        if (countLower < MIN_LOWER) validPassword = false;
        if (countUpper < MIN_UPPER) validPassword = false;
        if (countDigit < MIN_DIGITS) validPassword = false;
        if (countSpecial < MIN_SPECIAL) validPassword = false;

        return validPassword;
    }

    public void setPassword(String username, String password) {
        if (username.equals(getCurrentUserName())) {
            if (isValidPassword(password)) {
                Optional<User> userOptional = userRepository.findById(username);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    user.setPassword(passwordEncoder.encode(password));
                    userRepository.save(user);
                }
                else {
                    throw new UserNotFoundException();
                }
            }
            else {
                throw new BadRequestException();
            }
        }
        else {
            throw new BadRequestException();
        }

    }
    public void AssignConsultToUser(String username, Long consultId){
        var optionalUsername = userRepository.findById(username);
        var optionalConsult = consultRepository.findById(consultId);

        if (optionalUsername.isPresent()&& optionalUsername.isPresent()){
            var userName = optionalUsername.get();
            var consult = optionalConsult.get();
            var consults = userName.getConsult();
            consults.add(consult);
            userName.setConsult(consults);
            userRepository.save(userName);
        }
    }
    public void AssignImageToUser(String username, Long imageId){
        var optionalUsername = userRepository.findById(username);
        var optionalImage = imageRepository.findById(imageId);

        if (optionalUsername.isPresent()&& optionalUsername.isPresent()){
            var userName = optionalUsername.get();
            var image = optionalImage.get();
            var Images = userName.getImage();
//            image.add(image);
//            userName.setImage(image);
            userRepository.save(userName);
        }
    }

//    public void assignImageToUser(Long id, Long imageId) {
//        if ((!imageRepository.existsById(id)) || (!imageRepository.existsById(imageId)))
//            throw new RecordNotFoundException();
//        User user = userRepository.findById(id).get();
//        Image image = imageRepository.findById(imageId).get();
//        user.setImage((List<Image>) image);
//        userRepository.save(user);
//    }
}

