package com.example.springboot_project_eind.controller;


import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    public ConsultController(ConsultService consultService) {
        this.consultService = consultService;
    }

    @GetMapping(value = "/consult")
    public ResponseEntity getConsult() {
        Iterable<Consult> consult;
        consult = consultService.findAll();
        return ResponseEntity.ok(consult);
    }

    @GetMapping(value = "/consult/{nr}")
    public ResponseEntity getConsult(@PathVariable long nr) {
        Consult consult = consultService.findById(nr);
        return ResponseEntity.ok(consult);
    }

    @PostMapping(value = "/consult")
    public ResponseEntity addConsult(@RequestBody Consult consult) {
        consultService.save(consult);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/consult/{nr}")
    public ResponseEntity deleteConsult(@PathVariable long nr) {
        consultService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/consult/{nr}")
    public ResponseEntity updateConsult(@PathVariable long nr, @RequestBody Consult consult) {
        return ResponseEntity.ok("Aangepast");
    }

}
