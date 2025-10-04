package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class RaffleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RAFFLE_ID;
    private LocalDate date;
    private String prize;
    @OneToMany(mappedBy = "raffle")
    private Set<RaffleTicketModel> tickets;
    @ManyToOne
    @JoinColumn(name = "adm_id")
    private AdminModel adm;

    public RaffleModel(){}

    public RaffleModel(String prize, LocalDate date){
        this.prize = prize;
        this.date = date;
    }

}
