package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public AdminService adminService;

    @PostMapping("/createRaffle")
    public RaffleModel createRaffle(RaffleModel raffleModel){
        return adminService.createRaffle(raffleModel);
    }
}
