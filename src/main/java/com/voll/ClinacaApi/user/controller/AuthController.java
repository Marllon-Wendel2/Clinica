package com.voll.ClinacaApi.user.controller;

import com.voll.ClinacaApi.infra.security.DataTokenJWT;
import com.voll.ClinacaApi.infra.security.TokenService;
import com.voll.ClinacaApi.user.dtos.DataAuth;
import com.voll.ClinacaApi.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity loginAuth(@RequestBody DataAuth data) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(authenticationToken);

        var token = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(token));
    }

}
