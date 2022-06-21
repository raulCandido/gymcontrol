package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.dto.TokenDto;
import br.com.gym.gymcontrol.model.form.LoginForm;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken login = loginForm.converter();

        try {
            Authentication authenticate = authenticationManager.authenticate(login);

            String token = tokenService.gerarToken(authenticate);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();

        }

    }
}
