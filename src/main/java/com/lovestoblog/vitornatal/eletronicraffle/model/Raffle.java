//package com.lovestoblog.vitornatal.eletronicraffle.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//@Entity
//public class Raffle {
//    @Id
//    private long RAFFLE_ID;
//    private LocalDate date;
//    private String prize;
//    @ManyToMany
//    @JoinTable(
//            name = "RAFFLE_PARTICIPANTS")
//    private Set<UserModel> participants;
//    private int participantsQtt = getParticipantsQtt();
//    @OneToOne
//    @JoinColumn (name = "USER_ID")
//    private UserModel winner;
//
//    public Raffle(){}
//
//    public Raffle(String prize, LocalDate date){
//        this.prize = prize;
//        this.date = date;
//    }
//    public int getParticipantsQtt(){
//        return participants.size();
//    }
//
//}
