package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;

public class RaffleMapper {
    public RaffleResponseDTO map(RaffleModel raffleModel){
        RaffleResponseDTO raffleDTO = new RaffleResponseDTO();
        raffleDTO.setRAFFLE_ID(raffleModel.getRAFFLE_ID());
        raffleDTO.setDate(raffleModel.getDate());
        raffleDTO.setPrize(raffleModel.getPrize());
        return raffleDTO;
    }
}
