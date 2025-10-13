package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.RaffleTicketResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import org.springframework.stereotype.Component;

@Component
public class RaffleTicketMapper {



    public RaffleTicketResponseDTO map(RaffleTicketModel raffleTicketModel){
        var raffleModel = raffleTicketModel.getRaffleModel();
        RaffleTicketResponseDTO raffleTicketDTO = new RaffleTicketResponseDTO();
        raffleTicketDTO.setRAFFLETICKET_ID(raffleTicketModel.getRAFFLETICKET_ID());
        raffleTicketDTO.setUser(raffleTicketModel.getUser());
        raffleTicketDTO.setRaffleDTO(new RaffleResponseDTO(
                raffleModel.getRAFFLE_ID(),
                raffleModel.getDate(),
                raffleModel.getPrize()
        ));
        return raffleTicketDTO;
    }


}
