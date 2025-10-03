package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    @Id
    private Long USER_ID;
    private String name;
    private String cpf;
    private String email;
//    @JoinTable(
//            name = "RAFFLETICKET_REGISTERS",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "RAFFLETICKET_ID"))
//    private Set<Raffle> raffle;

    public UserModel(){}

    public UserModel(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return USER_ID;
    }

    public String getCpf() {
        return cpf;
    }
}
