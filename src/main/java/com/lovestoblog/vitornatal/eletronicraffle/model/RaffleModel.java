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
    private long RAFFLE_ID;

    private LocalDate date;

    private String prize;

    @OneToMany(mappedBy = "raffleModel")
    @JsonIgnore
    private Set<RaffleTicketModel> tickets;

    @ManyToOne
    @JoinColumn(name = "adm_id")
    private AdminModel adm;
}
