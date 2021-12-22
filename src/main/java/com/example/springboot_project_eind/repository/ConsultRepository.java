package com.example.springboot_project_eind.repository;

import com.example.springboot_project_eind.model.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ConsultRepository extends JpaRepository<Consult, Long> {

//   Collection<Consult> findByUserName(String username);
}
