package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RaffleTicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RAFFLETICKET_ID;

    @ManyToOne
    @JoinColumn(name="raffle_id")
    private RaffleModel raffleModel;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserModel user;
}
