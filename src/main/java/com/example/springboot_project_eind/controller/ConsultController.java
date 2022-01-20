package com.example.springboot_project_eind.controller;


import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.service.ConsultService;
import com.example.springboot_project_eind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ConsultController {

    @Autowired
    private ConsultService consultService;
    private UserService userService;

    public ConsultController(ConsultService consultService, UserService userService) {
        this.consultService = consultService;
        this.userService = userService;
    }

    @GetMapping(value = "/consult")
    public ResponseEntity getConsult() {
        Iterable<Consult> consult;
        consult = consultService.findAll();
        return ResponseEntity.ok(consult);
    }

    @GetMapping(value = "/consult/{id}")
    public ResponseEntity getConsult(@PathVariable long id) {
        Consult consult = consultService.findById(id);
        return ResponseEntity.ok(consult);
    }


//    @GetMapping(value = "/consult/{username}")
//    public ResponseEntity findByUserName(@PathVariable String username) {
//        Consult consult = consultService.findByUserName(username);
//        return ResponseEntity.ok(consult);
//    }

    @PostMapping(value = "/consult/{username}")
    public ResponseEntity addConsult(@PathVariable("username") String username, @RequestBody Consult consult) {
        var consultId = consultService.save(consult);
        userService.AssignConsultToUser(username, consultId);
        return ResponseEntity.ok(consult);
    }

    @DeleteMapping(value = "/consult/{id}")
    public ResponseEntity deleteConsult(@PathVariable long id) {
        consultService.deleteById(id);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/consult/{id}")
    public ResponseEntity updateConsult(@PathVariable long id, @RequestBody Consult consult) {
        return ResponseEntity.ok("Aangepast");
    }

}
