package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    private RaffleService raffleService;

    public AdminService(AdminRepository adminRepository, RaffleService raffleService){
        this.adminRepository = adminRepository;
        this.raffleService = raffleService;
    }

    public RaffleModel createRaffle(RaffleModel raffleModel){
        return raffleService.createRaffle(raffleModel);
    }

    public void deleteRaffle(Long id){
        raffleService.deleteRaffle(id);
    }

    public RaffleModel editRaffle(Long id, RaffleModel raffle){
        return raffleService.editRaffle(id, raffle);
    }
}
