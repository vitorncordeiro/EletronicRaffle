package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.RaffleDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;

public class RaffleMapper {
    public RaffleDTO map(RaffleModel raffleModel){
        RaffleDTO raffleDTO = new RaffleDTO();
        raffleDTO.setRAFFLE_ID(raffleModel.getRAFFLE_ID());
        raffleDTO.setDate(raffleModel.getDate());
        raffleDTO.setPrize(raffleModel.getPrize());
        return raffleDTO;
    }
}
