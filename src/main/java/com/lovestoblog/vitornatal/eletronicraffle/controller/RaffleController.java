package com.lovestoblog.vitornatal.eletronicraffle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class RaffleController {

    @GetMapping("/welcome")
    public String greetings(){
        return "Welcome";
    }
}
