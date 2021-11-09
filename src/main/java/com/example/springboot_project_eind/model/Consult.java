package com.example.springboot_project_eind.model;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 600)
    public String advice;

    @Column
    public LocalDate dateOfAppointment;

    @Column
    public String productAdvice;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public LocalDate getDateOfAppointment() {return dateOfAppointment;}

    public void setDateOfAppointment (LocalDate dateOfAppointment) {this.dateOfAppointment = dateOfAppointment;}

    public String getProductAdvice() {return productAdvice;}

    public void setProductAdvice(String ProductAdvice) {this.productAdvice = productAdvice;}






}
