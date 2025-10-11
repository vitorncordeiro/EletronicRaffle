package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import com.lovestoblog.vitornatal.eletronicraffle.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}/tickets")
    public Set<RaffleTicketModel> getUser(@PathVariable Long id){
        return userService.getUserTickets(id);
    }

}
