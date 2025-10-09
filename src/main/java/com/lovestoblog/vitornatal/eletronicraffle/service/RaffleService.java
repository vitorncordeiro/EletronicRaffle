package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import org.springframework.stereotype.Service;

@Service
public class RaffleService {
    public RaffleRepository raffleRepository;
    public RaffleModel createRaffle(RaffleModel raffleModel){
        return raffleRepository.save(raffleModel);
    }
    public void deleteRaffle(Long id){
        raffleRepository.deleteById(id);
    }

}
