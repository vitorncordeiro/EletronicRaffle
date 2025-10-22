package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.infra.security.JWTUserData;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleMapper;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RaffleService {
    private final UserRepository userRepository;
    private final RaffleTicketMapper raffleTicketMapper;
    public RaffleRepository raffleRepository;
    public RaffleMapper raffleMapper;
    public RaffleTicketService raffleTicketService;
    public Random random = new Random();

    public RaffleService(UserRepository userRepository, RaffleMapper raffleMapper, RaffleRepository raffleRepository,
                         RaffleTicketService raffleTicketService, RaffleTicketMapper raffleTicketMapper) {
        this.userRepository = userRepository;
        this.raffleMapper = raffleMapper;
        this.raffleRepository = raffleRepository;
        this.raffleTicketService = raffleTicketService;
        this.raffleTicketMapper = raffleTicketMapper;
    }

    public RaffleResponseDTO createRaffle(RaffleRequestDTO raffleRequestDTO){
        JWTUserData principal = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = userRepository.findById(principal.userId()).orElseThrow(() -> new RuntimeException("User dont found"));
        var raffleModel = raffleMapper.map(raffleRequestDTO, user);
        raffleRepository.save(raffleModel);

        return raffleMapper.map(raffleModel);
    }

    public void deleteRaffle(Long raffleId){
        RaffleModel raffle = raffleOfAuthUser(raffleId);
        raffleRepository.deleteById(raffleId);

    }
    public RaffleResponseDTO editRaffle(Long id){
        RaffleModel raffle = raffleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Raffle inexistence"
        ));

        return raffleMapper.map(raffle);

    }

    public void runDraws(){
        List<RaffleModel> list = raffleRepository.findAllUnwonRafflesToday();
        list.forEach(r -> getDrawWinner(r.getRaffleId()));
    }

    public RaffleTicketResponseDTO getDrawWinner(Long raffleId){
        RaffleModel raffle = raffleOfAuthUser(raffleId);
        var tickets = raffleTicketService.getRafflesTickets(raffleId);
        var ticketQuantity = tickets.size();
        var winnerTicket = tickets.get(random.nextInt(ticketQuantity));
        raffle.setWinnerTicket(winnerTicket);
        raffleRepository.save(raffle);
        return raffleTicketMapper.map(raffleTicketService.getTicket(winnerTicket.getRAFFLETICKET_ID()));
    }

    public RaffleModel raffleOfAuthUser(Long raffleId){
        JWTUserData userData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var raffle = raffleRepository.findById(raffleId).orElseThrow(() -> new RuntimeException("Raffle doesnt exist"));
        if(!userData.userId().equals(raffle.getUser().getId())){
            throw new RuntimeException("You dont have permission to do this!");
        } else{
            return raffle;
        }
    }
}
