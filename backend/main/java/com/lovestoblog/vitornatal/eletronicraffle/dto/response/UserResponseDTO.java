package com.lovestoblog.vitornatal.eletronicraffle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long USER_ID;
    private String name;
    private String cpf;
    private String email;
}
