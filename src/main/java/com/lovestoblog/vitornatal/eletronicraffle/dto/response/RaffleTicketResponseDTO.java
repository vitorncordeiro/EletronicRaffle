package com.lovestoblog.vitornatal.eletronicraffle.dto.response;

import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaffleTicketResponseDTO {
    private long RAFFLETICKET_ID;
    private RaffleResponseDTO raffleDTO;
    private UserModel user;
}
