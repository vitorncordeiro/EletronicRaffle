package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public AdminService adminService;

    @PostMapping("/createRaffle")
    public RaffleModel createRaffle(RaffleModel raffleModel){
        return adminService.createRaffle(raffleModel);
    }

    @DeleteMapping("/deleteRaffle/{id}")
    public void deleteRaffle(@PathVariable Long id){
        adminService.deleteRaffle(id);
    }
    @PutMapping("/editRaffle/{id}")
    public RaffleModel editRaffle(@PathVariable Long id, @RequestBody RaffleModel raffle){
        return adminService.editRaffle(id, raffle);
    }
}
