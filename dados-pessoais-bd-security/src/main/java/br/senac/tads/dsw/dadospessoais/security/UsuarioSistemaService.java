package br.senac.tads.dsw.dadospessoais.security;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioSistemaService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, UsuarioSistema> mapUsuarios;

    @PostConstruct
    public void init() {
        mapUsuarios = new HashMap<>();
        mapUsuarios.put("luke", new UsuarioSistema("luke",
    "Luke Skywalker", passwordEncoder.encode("Abcd1234"),
                Arrays.asList(new Papel("PADAWAN"), new Papel("JEDI"))));
        mapUsuarios.put("vader", new UsuarioSistema("vader",
                "Darth Vader", passwordEncoder.encode("Abcd1234"),
                Arrays.asList(new Papel("LORD_SITH"))));
        mapUsuarios.put("kenobi", new UsuarioSistema("kenobi",
                "Obi Wan Kenobi", passwordEncoder.encode("Abcd1234"),
                Arrays.asList(new Papel("MESTRE"), new Papel("JEDI"))));
    }

    @Override
    public UsuarioSistema loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UsuarioSistema user = mapUsuarios.get(username);
        if (user == null) {
            UsernameNotFoundException ex = new UsernameNotFoundException(username);
            throw ex;
        }
        return user;
    }
}
