//package com.lovestoblog.vitornatal.eletronicraffle.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class RaffleTicket {
//    @Id
//    private long RAFFLETICKET_ID;
//    @ManyToOne (optional = false)
//    @JoinTable(
//            name = "RAFFLE_ID",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "RAFFLE_ID"))
//    private Raffle raffle;
//
//    public RaffleTicket(){}
//
//
//}
