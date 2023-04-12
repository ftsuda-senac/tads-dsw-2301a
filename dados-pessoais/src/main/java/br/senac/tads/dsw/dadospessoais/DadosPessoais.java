package br.senac.tads.dsw.dadospessoais;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    private String nome;

    //@JsonProperty("nome_social")
    private String apelido;

    private String email;

    private String telefone;

    private String senha;

    private LocalDate dataNascimento;

    private List<String> conhecimentos;

    public DadosPessoais(String nome, String apelido, String email, String telefone, String senha, LocalDate dataNascimento, List<String> conhecimentos) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.conhecimentos = conhecimentos;
    }

    public DadosPessoais() {
    }

    public String getNome() {
        return this.nome;
    }

    public String getApelido() {
        return this.apelido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getSenha() {
        return this.senha;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public List<String> getConhecimentos() {
        return this.conhecimentos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setConhecimentos(List<String> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }
}
