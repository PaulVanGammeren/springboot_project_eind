package com.example.springboot_project_eind.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@IdClass(Authority.class)
@Table(name ="authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    public Authority(String username, String authorityString) {
    }

    public Authority() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
