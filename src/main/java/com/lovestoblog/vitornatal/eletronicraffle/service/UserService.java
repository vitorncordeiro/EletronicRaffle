package com.lovestoblog.vitornatal.eletronicraffle.service;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleTicketRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.request.UserUpdateDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.UserResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.RaffleTicketMapper;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;
    private final RaffleTicketService raffleTicketService;
    private final UserMapper userMapper;
    private final RaffleTicketMapper raffleTicketMapper;
    private final PasswordEncoder passwordEncoder;

    public List<RaffleTicketResponseDTO> getUserTickets(Long id){
        var result = raffleTicketService.getUserTickets(id);
        return result.stream()
                .map(ticket -> raffleTicketMapper.map(ticket))
                .toList();

    }
    public RaffleTicketResponseDTO createTicket(RaffleTicketRequestDTO ticketDTO){
        return raffleTicketService.createTicket(ticketDTO);
    }
    public UserResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO){
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        if(userUpdateDTO.getName() != null){
            userModel.setName(userUpdateDTO.getName());
        }
        if(userUpdateDTO.getEmail() != null){
            userModel.setEmail(userUpdateDTO.getEmail());
        }
        userRepository.save(userModel);
        return userMapper.map(userModel);
    }
    public UserModel save(UserModel userModel){
        String password = userModel.getPassword();
        userModel.setPassword(passwordEncoder.encode(password));

        userRepository.save(userModel);
        return userModel;
    }

}
