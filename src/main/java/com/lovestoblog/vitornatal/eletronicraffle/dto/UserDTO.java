package com.lovestoblog.vitornatal.eletronicraffle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long USER_ID;
    private String name;
    private String cpf;
    private String email;
}
