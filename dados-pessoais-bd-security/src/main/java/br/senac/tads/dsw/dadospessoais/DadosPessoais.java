package br.senac.tads.dsw.dadospessoais;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pessoa")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Preencha seu nome seu animal")
    @Size(max = 100)
    @Column(name = "nome_completo")
    private String nome;

    //@JsonProperty("nome_social")
    @NotBlank
    @Size(max = 64)
    @Column(unique = true)
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
    @ManyToMany
    @JoinTable(name = "pessoa_conhecimento",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "conhecimento_id"))
    private Set<Conhecimento> conhecimentos;

    @OneToMany(mappedBy = "pessoa")
    private Set<FotoPessoa> fotos;

    public DadosPessoais(String nome, String apelido, String email, String telefone, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public DadosPessoais() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Conhecimento> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(Set<Conhecimento> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public Set<FotoPessoa> getFotos() {
        return fotos;
    }

    public void setFotos(Set<FotoPessoa> fotos) {
        this.fotos = fotos;
    }
}
