package com.lovestoblog.vitornatal.eletronicraffle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaffleDTO {
    private long RAFFLE_ID;
    private LocalDate date;
    private String prize;
}
