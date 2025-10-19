package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.infra.security.JWTUserData;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RaffleService {
    private final UserRepository userRepository;
    public RaffleRepository raffleRepository;
    public RaffleMapper raffleMapper;

    public RaffleService(UserRepository userRepository, RaffleMapper raffleMapper, RaffleRepository raffleRepository) {
        this.userRepository = userRepository;
        this.raffleMapper = raffleMapper;
        this.raffleRepository = raffleRepository;
    }

    public RaffleModel createRaffle(RaffleRequestDTO raffleRequestDTO){
        JWTUserData principal = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = userRepository.findById(principal.userId()).orElseThrow(() -> new RuntimeException("User dont found"));


        var raffleModel = raffleMapper.map(raffleRequestDTO, user);

        return raffleRepository.save(raffleModel);
    }








    public void deleteRaffle(Long id){
        raffleRepository.deleteById(id);
    }

    public RaffleModel editRaffle(Long id, RaffleModel raffle){
        if(raffleRepository.existsById(id)){
            raffleRepository.save(raffle);
        }
        return null;

    }
}
