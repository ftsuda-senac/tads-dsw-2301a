package br.senac.tads.dsw.dadospessoais.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String senha) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, senha));

        UsuarioSistema usuario = (UsuarioSistema) auth.getPrincipal();
        return "OK - " + usuario.getNomeCompleto();
    }
}
