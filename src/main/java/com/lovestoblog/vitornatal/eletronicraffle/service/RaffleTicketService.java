package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleTicketRepository;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
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

    public List<RaffleTicketModel> getUserTickets(Long id){
        return raffleTicketRepository.findByUser_Id(id);
    }
    public RaffleTicketResponseDTO createTicket(RaffleTicketRequestDTO ticketRequestDTO){
        var raffle = raffleRepository.findById(ticketRequestDTO.getRaffleId())
                .orElseThrow(() -> new RuntimeException("Raffle not found"));
        var user = userRepository.findById(ticketRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var ticket = new RaffleTicketModel();
        ticket.setRaffleModel(raffle);
        ticket.setUser(user);
        var model = raffleTicketRepository.save(ticket);
        return raffleTicketMapper.map(model);
    }
}
