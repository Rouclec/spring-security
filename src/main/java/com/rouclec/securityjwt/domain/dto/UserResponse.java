package com.rouclec.securityjwt.domain.dto;

import com.rouclec.securityjwt.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    //@Min(), @Max, @NotNull
}
