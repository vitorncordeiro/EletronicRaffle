package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ADM_ID;

    private String name;

    private int activiesQtt;

    private String cpf;

    @OneToMany(mappedBy = "adm")
    private Set<RaffleModel> raffleModels;

}
