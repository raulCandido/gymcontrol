package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.dto.request.AuthRequestDto;
import br.com.gym.gymcontrol.model.dto.request.TokenRequestDto;
import br.com.gym.gymcontrol.service.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenService tokenService;

    private AuthController authController;

    @BeforeEach
    void setUp() {
        authController = new AuthController(authenticationManager, tokenService);
    }

    @Test
    void testAuth() {
        Mockito.when(tokenService.gerarToken(any())).thenReturn("jwt");
        ResponseEntity<TokenRequestDto> response = authController.auth(new AuthRequestDto("email", "senha"));
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testExceptionAuth() {
        Mockito.when(authenticationManager.authenticate(any())).thenThrow(Mockito.mock(AuthenticationException.class));
        ResponseEntity<TokenRequestDto> response = authController.auth(new AuthRequestDto("email", "senha"));
        Assertions.assertEquals(400, response.getStatusCode().value());
    }
}