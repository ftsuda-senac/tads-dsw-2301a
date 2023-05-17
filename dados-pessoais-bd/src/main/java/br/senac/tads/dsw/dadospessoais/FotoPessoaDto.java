package br.senac.tads.dsw.dadospessoais;

public class FotoPessoaDto {

    private Integer id;

    private String nomeArquivo;

    private String legenda;

    public FotoPessoaDto() {
    }

    public FotoPessoaDto(Integer id, String nomeArquivo, String legenda) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;
        this.legenda = legenda;
    }

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
}
