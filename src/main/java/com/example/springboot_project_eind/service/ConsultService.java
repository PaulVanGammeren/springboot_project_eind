package com.example.springboot_project_eind.service;


import com.example.springboot_project_eind.exceptions.RecordNotFoundException;
import com.example.springboot_project_eind.model.Consult;
import com.example.springboot_project_eind.repository.ConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultService {

    private final ConsultRepository consultRepository;

    @Autowired
    public ConsultService(ConsultRepository consultRepository) {
        this.consultRepository = consultRepository;
    }

    public Iterable<Consult> findAll() {
        Iterable<Consult> consult = consultRepository.findAll();
        return consult;
    }

    public Consult findById(long nr) {
        Optional<Consult> consult = consultRepository.findById(nr);
        if (consult.isPresent()) {
            return consult.get();
        }
        else {
            throw new RecordNotFoundException("Consult with id " + nr + " not found");
        }
    }

    public void save(Consult consult) {
        consultRepository.save(consult);
    }

    public void deleteById(long nr) {
        try {
            consultRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

}
