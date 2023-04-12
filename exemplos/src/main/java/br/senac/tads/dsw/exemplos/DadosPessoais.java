package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    private String nome;

    private String apelido;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;

    private List<String> conhecimentos;

    public DadosPessoais() {

    }

    public DadosPessoais(String nome, String apelido, String email, String telefone, LocalDate dataNascimento, List<String> conhecimentos) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.conhecimentos = conhecimentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<String> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<String> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }
}
