package ru.bgpu.splk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bgpu.splk.dto.login.LoginRequestDto;

@RestController
public class LoginController {

    @Autowired private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDto loginRequest) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                loginRequest.getLogin(), loginRequest.getPassword()
        );
        Authentication authenticationResponse = this.authenticationManager.authenticate(
                authenticationRequest
        );
        // ...
        return ResponseEntity.ok().build();
    }


}
