package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.service.RaffleTicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@Tag(name = "Raffle Tickets", description = "Endpoints for managing raffle tickets")
public class RaffleTicketController {

    public final RaffleTicketService raffleTicketService;

    public RaffleTicketController(RaffleTicketService raffleTicketService){
        this.raffleTicketService = raffleTicketService;
    }
    @Operation(summary = "Get user tickets", description = "Retrieve all raffle tickets for the authenticated user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tickets retrieved successfully"),
            @ApiResponse(responseCode = "403", description = "Unauthorized, user not authenticated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/tickets")
    public List<RaffleTicketResponseDTO> getUserTickets(){
        return raffleTicketService.getUserTickets();
    }

    @Operation(summary = "Create a new ticket", description = "Creates a new raffle ticket for the user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ticket created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "403", description = "Unauthorized, user not authenticated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/create-ticket")
    public ResponseEntity<String> createTicket(@RequestBody RaffleTicketRequestDTO ticketDTO){
        RaffleTicketResponseDTO response = raffleTicketService.createTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ticket number " + response.getRAFFLETICKET_ID() + " created successfully!");
    }

}
