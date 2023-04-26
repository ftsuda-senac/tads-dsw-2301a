package br.senac.tads.dsw.dadospessoais;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    @NotBlank(message = "Preencha seu nome seu animal")
    @Size(max = 100)
    private String nome;

    //@JsonProperty("nome_social")
    @NotBlank
    @Size(max = 64)
    private String apelido;

    @NotBlank
    @Size(max = 200)
    @Email
    private String email;

    @Size(max = 16)
    private String telefone;

    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

    @PastOrPresent
    private LocalDate dataNascimento;

    @Size(min = 1)
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
