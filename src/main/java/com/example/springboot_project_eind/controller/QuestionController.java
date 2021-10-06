package com.example.springboot_project_eind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {


    private static String[] questions = {
            "where is Amsterdam",
            "Where is New York",
    };
    private static String[] answers = {
            "In the Netherlands",
            "In the USA ",
    };

    @GetMapping(value = "/questions")     //collection
    public String[] getQuestions() {
        return questions;
    }

    @GetMapping(value = "/questions/{nr}")          //item
    public String getQuestion(@PathVariable int nr) {
        return questions[nr];

    }

    @GetMapping(value = "/questions/{nr}/answer")        //document
    public String getAnswer(@PathVariable int nr) {
        return answers[nr];

    }

    @PostMapping(value= "/questions")
    public void addQuestion(){
        //voeg een vraag toe.
    }

    @GetMapping(value = "/info")
    public static String sayHello() {
        return "hello World";
    }

}
