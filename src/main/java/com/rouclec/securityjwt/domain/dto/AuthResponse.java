package com.rouclec.securityjwt.domain.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
}
