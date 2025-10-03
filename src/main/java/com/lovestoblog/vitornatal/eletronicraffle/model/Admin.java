//package com.lovestoblog.vitornatal.eletronicraffle.model;
//
//import jakarta.persistence.*;
//
//import java.util.Set;
//
//@Entity
//public class Admin {
//    @Id
//    private long ADM_ID;
//    private String name;
//    private int activiesQtt;
//    private String cpf;
//    @OneToMany
//    @JoinTable(
//            name = "RAFFLE_REALESES",
//            joinColumns = @JoinColumn(name = "ADM_ID"),
//            inverseJoinColumns = @JoinColumn(name = "RAFFLE_ID"))
//    private Set<Raffle> raffle;
//
//
//    public Admin(){}
//
//    public Admin(String name, String cpf) {
//        this.name = name;
//        this.cpf = cpf;
//    }
//
//    public Long getADM_ID() {
//        return ADM_ID;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//}
