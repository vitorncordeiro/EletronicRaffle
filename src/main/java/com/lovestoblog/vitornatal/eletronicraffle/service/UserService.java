package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;
    private final RaffleTicketService raffleTicketService;
    private final UserMapper userMapper;
    private final RaffleTicketMapper raffleTicketMapper;

    public List<RaffleTicketResponseDTO> getUserTickets(Long id){
        var result = raffleTicketService.getUserTickets(id);
        return result.stream()
                .map(ticket -> raffleTicketMapper.map(ticket))
                .toList();

    }
    public RaffleTicketResponseDTO createTicket(RaffleTicketRequestDTO ticketDTO){
        return raffleTicketService.createTicket(ticketDTO);
    }

}
