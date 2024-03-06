package com.rouclec.securityjwt.services;

import com.rouclec.securityjwt.Mappers.impl.UserMapperImp;
import com.rouclec.securityjwt.domain.dto.AuthResponse;
import com.rouclec.securityjwt.domain.dto.UserRequest;
import com.rouclec.securityjwt.domain.entity.User;
import com.rouclec.securityjwt.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapperImp userMapperImp;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse register(UserRequest request, HttpServletResponse response){
        User user = userMapperImp.MapFrom(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        String token = jwtService.generateToken(user);
        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setPath("/");
        // Set any other desired cookie properties, such as expiration, domain, secure, etc.
        response.addCookie(jwtCookie);
        return new AuthResponse(token);

    }

    public  AuthResponse login(UserRequest request, HttpServletResponse response){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setPath("/");
        // Set any other desired cookie properties, such as expiration, domain, secure, etc.
        response.addCookie(jwtCookie);
        return new AuthResponse(token);
    }
}
