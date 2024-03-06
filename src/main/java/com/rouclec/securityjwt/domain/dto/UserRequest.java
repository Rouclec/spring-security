package com.rouclec.securityjwt.domain.dto;

import com.rouclec.securityjwt.domain.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {

    private Long id;
    @NotNull(message = "Please enter your firstname")
    private String firstname;
    @NotNull(message = "Please enter your last name")
    private String lastname;
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = ".{6,}", message = "Password must be at least 6 characters long")
    private String password;
    @NotNull
    private Role role;

    //@Min(), @Max, @NotNull
}
