package br.senac.tads.dsw.dadospessoais;

@RepeticaoSenha
public class Senha {

    private String valor;

    private String repeticao;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(String repeticao) {
        this.repeticao = repeticao;
    }
}
