package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RaffleRequestDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class RaffleMapper {
    public RaffleResponseDTO map(RaffleModel raffleModel){
        RaffleResponseDTO raffleDTO = new RaffleResponseDTO();
        raffleDTO.setRAFFLE_ID(raffleModel.getRaffleId());
        raffleDTO.setDate(raffleModel.getDate());
        raffleDTO.setPrize(raffleModel.getPrize());
        return raffleDTO;
    }

    public RaffleModel map(RaffleRequestDTO raffleRequestDTO, UserModel user){
        RaffleModel raffle = new RaffleModel();
        raffle.setDate(raffleRequestDTO.date());
        raffle.setPrize(raffleRequestDTO.prize());
        raffle.setUser(user);
        return raffle;
    }
}
