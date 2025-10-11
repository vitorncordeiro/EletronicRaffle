package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.RaffleTicketRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RaffleTicketService {
    private final RaffleTicketRepository raffleTicketRepository;

    public RaffleTicketService(RaffleTicketRepository raffleTicketRepository){
        this.raffleTicketRepository = raffleTicketRepository;
    }

    public Set<RaffleTicketModel> getUserTickets(Long id){
        return raffleTicketRepository.findByUserId(id);
    }
}
