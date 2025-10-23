package com.example.shoppinglist.web;

import com.example.shoppinglist.dto.AccountCredentialsDto;
import com.example.shoppinglist.service.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentialsDto credentialsDto) {
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(
                credentialsDto.getUsername(),
                credentialsDto.getPassword()
        );
        Authentication auth = authenticationManager.authenticate(creds);
        String jwts= jwtService.getToken(auth.getName());

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorozation")
                .build();
    }
}
