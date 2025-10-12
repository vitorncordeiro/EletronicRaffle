package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.RaffleTicketDTO;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RaffleTicketService raffleTicketService;
    private final UserMapper userMapper;
    private final RaffleTicketMapper raffleTicketMapper;


    public UserService(UserRepository userRepository, RaffleTicketService raffleTicketService, UserMapper userMapper
    , RaffleTicketMapper raffleTicketMapper){
        this.userRepository = userRepository;
        this.raffleTicketService = raffleTicketService;
        this.userMapper = userMapper;
        this.raffleTicketMapper = raffleTicketMapper;
    }

    public List<RaffleTicketDTO> getUserTickets(Long id){
        var result = raffleTicketService.getUserTickets(id);
        return result.stream()
                .map(ticket -> raffleTicketMapper.map(ticket))
                .toList();

    }

}
