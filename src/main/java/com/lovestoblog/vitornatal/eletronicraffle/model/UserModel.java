package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long USER_ID;
    private String name;

    private String cpf;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<RaffleTicketModel> tickets;
}
