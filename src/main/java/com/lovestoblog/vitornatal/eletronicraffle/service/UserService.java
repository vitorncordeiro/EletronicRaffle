package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RaffleTicketService raffleTicketService;


    public UserService(UserRepository userRepository, RaffleTicketService raffleTicketService){
        this.userRepository = userRepository;
        this.raffleTicketService = raffleTicketService;
    }

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }
}
