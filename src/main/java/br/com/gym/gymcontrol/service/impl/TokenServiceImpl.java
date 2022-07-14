package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${origens.jwt.expiration}")
    private String tempoExpiracao;

    @Value("${origens.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authenticate) {
        Usuario usuario = (Usuario) authenticate.getPrincipal();

        Date dataCriacaoToken = new Date();
        Date dataExpiracaoToken = new Date(dataCriacaoToken.getTime() + Long.parseLong(tempoExpiracao));

        return Jwts.builder().setIssuer("API Origens BJJ") // Nome da app quando o cliente for gerar token
                .setSubject(usuario.getId().toString()) // passando identificador unico de usuario do token gerado
                .setIssuedAt(dataCriacaoToken) // data de criacao do token
                .setExpiration(dataExpiracaoToken) // data de expiracao do token
                .signWith(SignatureAlgorithm.HS256, secret) // forma de encriptacao e codigo de encriptacao
                .compact();
    }

    @Override
    public Long getTokenId(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.valueOf(body.getSubject());
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
