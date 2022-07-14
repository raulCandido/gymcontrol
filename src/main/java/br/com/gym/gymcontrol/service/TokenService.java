package br.com.gym.gymcontrol.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    boolean isTokenValid(String token);
    String gerarToken(Authentication authenticate);

    Long getTokenId(String token);
}
