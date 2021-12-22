package com.example.springboot_project_eind.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;



@Entity
@Table(name = "files")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String type;



    @Column(name = "file", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] file;

    public Image() {
    }

    public Image(String fileName, String type, byte[] file) {
        this.fileName = fileName;
        this.type = type;
        this.file = file;
    }
//
//    @OneToOne(mappedBy = "image")
//    @JsonBackReference(value = "user-image")
//    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }




}