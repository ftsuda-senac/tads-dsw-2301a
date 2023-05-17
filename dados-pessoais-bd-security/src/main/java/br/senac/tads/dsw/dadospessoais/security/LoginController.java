package br.senac.tads.dsw.dadospessoais.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

@RestController
public class LoginController {

    @Autowired
    private SecretKey chaveAssinatura;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String senha) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, senha));

        UsuarioSistema usuario = (UsuarioSistema) auth.getPrincipal();

        Claims claims = Jwts.claims()
                .setSubject(usuario.getUsername());
        claims.put("fullName", usuario.getNomeCompleto());

        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant expiration = issuedAt.plus(30, ChronoUnit.MINUTES);

        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(issuedAt))
                .setExpiration(Date.from(expiration))
                .signWith(chaveAssinatura)
                .compact();
        return jwt;
    }
}
