package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ADM_ID;
    private String name;
    private int activiesQtt;
    private String cpf;

    @OneToMany(mappedBy = "adm")
    private Set<RaffleModel> raffleModels;

    public AdminModel(){}

    public AdminModel(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Long getADM_ID() {
        return ADM_ID;
    }

    public String getCpf() {
        return cpf;
    }
}
