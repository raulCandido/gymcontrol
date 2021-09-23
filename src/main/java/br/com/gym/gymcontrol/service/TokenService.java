package br.com.gym.gymcontrol.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String gerarToken(Authentication authenticate);
}
