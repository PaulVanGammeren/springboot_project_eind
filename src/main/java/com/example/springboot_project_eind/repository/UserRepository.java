package com.example.springboot_project_eind.repository;

import com.example.springboot_project_eind.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, String>  {
}
