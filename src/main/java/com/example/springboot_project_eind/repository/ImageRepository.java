package com.example.springboot_project_eind.repository;

import com.example.springboot_project_eind.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
