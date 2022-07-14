package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.dto.request.AuthRequestDto;
import br.com.gym.gymcontrol.model.dto.request.TokenRequestDto;
import br.com.gym.gymcontrol.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenRequestDto> auth(@RequestBody @Valid AuthRequestDto authRequestDto) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authRequestDto.email(), authRequestDto.senha());

        try {
            Authentication authenticate = authenticationManager.authenticate(auth);
            String token = tokenService.gerarToken(authenticate);
            return ResponseEntity.ok(new TokenRequestDto(token, "Bearer"));

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}
