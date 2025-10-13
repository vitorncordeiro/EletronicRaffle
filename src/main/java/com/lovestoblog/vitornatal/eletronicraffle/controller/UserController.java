package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.request.UserUpdateDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.UserResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createTicket(@RequestBody RaffleTicketRequestDTO ticketDTO){
        RaffleTicketResponseDTO response = userService.createTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ticket number " + response.getRAFFLETICKET_ID() + " created successfully!");
    }
    @PatchMapping("/{id}/edit-profile")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponseDTO user = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user.getName() + "'s profile updated");

    }
}
