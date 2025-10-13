package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}/tickets")
    public List<RaffleTicketResponseDTO> getUser(@PathVariable Long id){
        return userService.getUserTickets(id);
    }
    @PostMapping("/{id}/create-ticket")
    public RaffleTicketResponseDTO createTicket(@RequestBody RaffleTicketRequestDTO ticketDTO){
        RaffleTicketResponseDTO response = userService.createTicket(ticketDTO);
        return response;
    }
}
