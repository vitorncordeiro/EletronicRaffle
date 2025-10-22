package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.service.RaffleService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/raffle")
@RestController
public class RaffleController {

    public final RaffleService raffleService;

    public RaffleController(RaffleService raffleService){
        this.raffleService = raffleService;
    }

    @PostMapping("/createRaffle")
    public RaffleResponseDTO createRaffle(@RequestBody RaffleRequestDTO raffleRequestDTO){
        return raffleService.createRaffle(raffleRequestDTO);
    }

    @DeleteMapping("/deleteRaffle/{id}")
    public void deleteRaffle(@PathVariable Long raffleId){
        raffleService.deleteRaffle(raffleId);
    }
    @PutMapping("/{id}/editRaffle")
    public RaffleModel editRaffle(@PathVariable Long id){
        return raffleService.editRaffle(id);
    }
    @PostMapping("/{id}/draw")
    public RaffleTicketResponseDTO getDrawWinner(@PathVariable Long id){

        return raffleService.getDrawWinner(id);
    }
}
