package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RaffleTicketService raffleTicketService;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, RaffleTicketService raffleTicketService, UserMapper userMapper){
        this.userRepository = userRepository;
        this.raffleTicketService = raffleTicketService;
        this.userMapper = userMapper;
    }

    public Set<RaffleTicketModel> getUserTickets(Long id){
        return raffleTicketService.getUserTickets(id);

    }

}
