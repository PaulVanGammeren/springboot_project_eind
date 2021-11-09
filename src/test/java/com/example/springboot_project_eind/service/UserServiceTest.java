package com.example.springboot_project_eind.service;

import com.example.springboot_project_eind.model.User;
import com.example.springboot_project_eind.repository.UserRepository;
import com.example.springboot_project_eind.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void getUserTest(){
        //create user
        User user1 = new User();
      user1.setUsername("paul");
      user1.setEmail("paul@gmail.com");



      //when
        when(userRepository.findById("paul")).thenReturn(Optional.of(user1));
        var user2 = userService.getUser("paul").get();

        assertThat(user2.getEmail()).isEqualTo("paul@gmail.com");


    }


}
