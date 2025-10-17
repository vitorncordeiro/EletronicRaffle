package com.lovestoblog.vitornatal.eletronicraffle.infra.security;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
