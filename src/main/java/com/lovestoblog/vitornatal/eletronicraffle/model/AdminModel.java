package com.lovestoblog.vitornatal.eletronicraffle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "adm")
    @JsonIgnore
    private Set<RaffleModel> raffleModels;

}
