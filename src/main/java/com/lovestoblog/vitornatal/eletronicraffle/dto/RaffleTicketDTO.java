package com.lovestoblog.vitornatal.eletronicraffle.dto;

import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaffleTicketDTO {
    private long RAFFLETICKET_ID;
    private RaffleDTO raffleDTO;
    private UserModel user;
}
