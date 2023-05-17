package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoaisDto {

    private String apelido;

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;

    private List<Integer> conhecimentosIds;

    private List<FotoPessoaDto> fotos;

    public DadosPessoaisDto() {
    }

    public DadosPessoaisDto(String apelido, String nome, String email, String telefone, LocalDate dataNascimento, List<Integer> conhecimentosIds, List<FotoPessoaDto> fotos) {
        this.apelido = apelido;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.conhecimentosIds = conhecimentosIds;
        this.fotos = fotos;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Integer> getConhecimentosIds() {
        return conhecimentosIds;
    }

    public void setConhecimentosIds(List<Integer> conhecimentosIds) {
        this.conhecimentosIds = conhecimentosIds;
    }

    public List<FotoPessoaDto> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoPessoaDto> fotos) {
        this.fotos = fotos;
    }
}
