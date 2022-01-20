package com.example.springboot_project_eind.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 80)
    private String password;

    @Column
    private boolean enabled = true;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(
            targetEntity = com.example.springboot_project_eind.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
   private Set<Authority> authorities = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private List<Consult> consult;
    //nog aanpassen

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private List <Image> image;





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<com.example.springboot_project_eind.model.Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public String getFullName() {
        return this.getUsername() + " " + this.getEmail();
    }

    public void addAuthority(String authorityString) {
        this.authorities.add(new Authority(this.username, authorityString));
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public List<Consult> getConsult() {
        return consult;
    }

    public void setConsult(List<Consult> consult) {
        this.consult = consult;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}

