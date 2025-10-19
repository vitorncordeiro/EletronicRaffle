package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import com.lovestoblog.vitornatal.eletronicraffle.service.RaffleTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class RaffleTicketController {

    public final RaffleTicketService raffleTicketService;

    public RaffleTicketController(RaffleTicketService raffleTicketService){
        this.raffleTicketService = raffleTicketService;
    }

    @GetMapping("/tickets")
    public List<RaffleTicketResponseDTO> getTickets(@AuthenticationPrincipal UserModel user){
        return raffleTicketService.getUserTickets(user.getId());
    }
    @PostMapping("/{id}/create-ticket")
    public ResponseEntity<String> createTicket(@RequestBody RaffleTicketRequestDTO ticketDTO){
        RaffleTicketResponseDTO response = raffleTicketService.createTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ticket number " + response.getRAFFLETICKET_ID() + " created successfully!");
    }

}
