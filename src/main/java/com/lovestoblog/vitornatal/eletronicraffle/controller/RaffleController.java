package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.service.RaffleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/raffles")
@RestController
@Tag(name = "Raffles", description = "Endpoints for managing raffles and drawing winners")
public class RaffleController {

    public final RaffleService raffleService;

    public RaffleController(RaffleService raffleService){
        this.raffleService = raffleService;
    }

    @GetMapping
    public List<RaffleResponseDTO> getRaffles(){
        return raffleService.getRaffles();
    }


    @Operation(summary = "Create a new raffle", description = "Creates a new raffle with the provided details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Raffle successfully created"),
            @ApiResponse(responseCode = "403", description = "Invalid user token"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public RaffleResponseDTO createRaffle(@RequestBody RaffleRequestDTO raffleRequestDTO){
        return raffleService.createRaffle(raffleRequestDTO);
    }

    @Operation(summary = "Delete a raffle", description = "Deletes a raffle by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Raffle successfully deleted"),
            @ApiResponse(responseCode = "403", description = "Invalid user token"),
            @ApiResponse(responseCode = "404", description = "Raffle not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deleteRaffle(@PathVariable Long raffleId){
        raffleService.deleteRaffle(raffleId);
    }

    @Operation(summary = "Edit a raffle", description = "Edits raffle details by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Raffle successfully updated"),
            @ApiResponse(responseCode = "403", description = "Invalid user token"),
            @ApiResponse(responseCode = "404", description = "Raffle not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public RaffleResponseDTO editRaffle(@PathVariable Long id){
        return raffleService.editRaffle(id);
    }

    @Operation(summary = "Draw a winner", description = "Performs the raffle draw and returns the winning ticket")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Winner drawn successfully"),
            @ApiResponse(responseCode = "404", description = "Raffle not found or no tickets available"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/{id}/draw")
    public RaffleTicketResponseDTO getDrawWinner(@PathVariable Long id){

        return raffleService.getDrawWinner(id);
    }
}
