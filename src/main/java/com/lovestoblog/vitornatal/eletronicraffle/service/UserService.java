package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.UserDTO;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserDTO getUser(Long id){
        Optional<UserModel> userByID = userRepository.findById(id);
        var user = userMapper.map(userByID.orElse(null));
        return user;
    }

}
