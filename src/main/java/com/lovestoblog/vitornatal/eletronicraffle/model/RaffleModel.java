package com.lovestoblog.vitornatal.eletronicraffle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RaffleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long raffleId;
    private LocalDate date;
    private String prize;
    @OneToOne
    @JoinColumn(name = "winner_ticket_id")
    private RaffleTicketModel winnerTicket;

    @OneToMany(mappedBy = "raffleModel")
    @JsonIgnore
    private Set<RaffleTicketModel> tickets;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
