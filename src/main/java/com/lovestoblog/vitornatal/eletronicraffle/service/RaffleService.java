package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.infra.security.JWTUserData;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    public RaffleResponseDTO createRaffle(RaffleRequestDTO raffleRequestDTO){
        JWTUserData principal = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = userRepository.findById(principal.userId()).orElseThrow(() -> new RuntimeException("User dont found"));
        var raffleModel = raffleMapper.map(raffleRequestDTO, user);
        raffleRepository.save(raffleModel);

        return raffleMapper.map(raffleModel);
    }

    public void deleteRaffle(Long raffleId){
        JWTUserData userData = (JWTUserData) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        var raffle = raffleRepository.findById(raffleId).orElseThrow(() -> new RuntimeException("Raffle doesnt exist"));
        if(!Objects.equals(raffle.getUser().getId(), userData.userId())){
            throw new RuntimeException("You dont have permission to exclude this raffle");
        }else{
            raffleRepository.deleteById(raffleId);
        }



    }

    public RaffleModel editRaffle(Long id, RaffleModel raffle){
        if(raffleRepository.existsById(id)){
            raffleRepository.save(raffle);
        }
        return null;

    }
}
