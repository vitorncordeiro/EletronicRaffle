package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
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
    public RaffleModel createRaffle(@RequestBody RaffleRequestDTO raffleRequestDTO){
        return raffleService.createRaffle(raffleRequestDTO);
    }

    @DeleteMapping("/deleteRaffle/{id}")
    public void deleteRaffle(@PathVariable Long id){
        raffleService.deleteRaffle(id);
    }
    @PutMapping("/editRaffle/{id}")
    public RaffleModel editRaffle(@PathVariable Long id, @RequestBody RaffleModel raffle){
        return raffleService.editRaffle(id, raffle);
    }
}
