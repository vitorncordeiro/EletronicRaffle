package com.lovestoblog.vitornatal.eletronicraffle.dto.request;

import com.lovestoblog.vitornatal.eletronicraffle.model.UserRole;

public record RegisterDTO(String password, String emaill, String name, UserRole role, String cpf) {
}
