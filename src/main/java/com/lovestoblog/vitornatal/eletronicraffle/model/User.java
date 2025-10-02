package com.lovestoblog.vitornatal.eletronicraffle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String cpf;
    private String email;


}
