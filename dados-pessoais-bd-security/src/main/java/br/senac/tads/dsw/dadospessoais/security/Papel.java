package br.senac.tads.dsw.dadospessoais.security;

import org.springframework.security.core.GrantedAuthority;

public class Papel implements GrantedAuthority {

    private String nome;

    public Papel() {
    }

    public Papel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}
