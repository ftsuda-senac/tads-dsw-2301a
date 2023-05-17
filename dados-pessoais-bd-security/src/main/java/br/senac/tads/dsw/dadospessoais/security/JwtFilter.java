package br.senac.tads.dsw.dadospessoais.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private SecretKey chaveAssinatura;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Header deve ser Bearer [TOKEN]
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            String jwt = authorizationHeader.substring(7);

            // Abrir e extrair informações do token
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(chaveAssinatura)
                    .build()
                    .parseClaimsJws(jwt);

            String username = claims.getBody().getSubject();
            List<Papel> papeis = new ArrayList<>();
            if (claims.getBody().get("scope") != null) {
                List<String> nomesPapeis = (ArrayList<String>) claims.getBody().get("scope");
                for (String nome : nomesPapeis) {
                    papeis.add(new Papel(nome));
                }
            }

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    claims.getBody().getSubject(),
                    "",
                    papeis);
            SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
