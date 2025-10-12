package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.RaffleDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.RaffleTicketDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import org.springframework.stereotype.Component;

@Component
public class RaffleTicketMapper {



    public RaffleTicketDTO map(RaffleTicketModel raffleTicketModel, RaffleModel raffleModel){
        RaffleTicketDTO raffleTicketDTO = new RaffleTicketDTO();
        raffleTicketDTO.setRAFFLETICKET_ID(raffleTicketModel.getRAFFLETICKET_ID());
        raffleTicketDTO.setUser(raffleTicketModel.getUser());
        raffleTicketDTO.setRaffleDTO(new RaffleDTO(
                raffleModel.getRAFFLE_ID(),
                raffleModel.getDate(),
                raffleModel.getPrize()
        ));
        return raffleTicketDTO;
    }
}
