package br.senac.tads.dsw.dadospessoais;

import jakarta.persistence.*;

@Entity
public class FotoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500)
    private String nomeArquivo;

    @Column(length = 1024)
    private String legenda;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private DadosPessoais pessoa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public DadosPessoais getPessoa() {
        return pessoa;
    }

    public void setPessoa(DadosPessoais pessoa) {
        this.pessoa = pessoa;
    }
}
