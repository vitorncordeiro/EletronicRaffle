package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.infra.security.JWTUserData;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleTicketRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaffleTicketService {
    private final RaffleTicketRepository raffleTicketRepository;
    private final RaffleTicketMapper raffleTicketMapper;
    private final RaffleRepository raffleRepository;
    private final UserRepository userRepository;

    public RaffleTicketService(RaffleTicketRepository raffleTicketRepository,
                               RaffleTicketMapper raffleTicketMapper,
                               RaffleRepository raffleRepository,
                               UserRepository userRepository){
        this.raffleTicketRepository = raffleTicketRepository;
        this.raffleTicketMapper = raffleTicketMapper;
        this.raffleRepository = raffleRepository;
        this.userRepository = userRepository;
    }

    public List<RaffleTicketResponseDTO> getUserTickets(){
        JWTUserData userData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var result = raffleTicketRepository.findByUser_Id(userData.userId());
        return result.stream()
                .map(ticket -> raffleTicketMapper.map(ticket))
                .toList();

    }
    public List<RaffleTicketResponseDTO> getRafflesTickets(Long raffleId){

        var list = raffleTicketRepository.findByRaffleModel_raffleId(raffleId);
        return list.stream()
                .map(ticket -> raffleTicketMapper.map(ticket))
                .toList();
    }

    public RaffleTicketResponseDTO createTicket(RaffleTicketRequestDTO ticketRequestDTO){
        JWTUserData principal = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = userRepository.findById(principal.userId()).orElseThrow(() -> new RuntimeException("User dont found"));
        var raffle = raffleRepository.findById(ticketRequestDTO.getRaffleId())
                .orElseThrow(() -> new RuntimeException("Raffle not found"));

        var ticket = new RaffleTicketModel();
        ticket.setRaffleModel(raffle);
        ticket.setUser(user);
        var model = raffleTicketRepository.save(ticket);
        return raffleTicketMapper.map(model);
    }




}
