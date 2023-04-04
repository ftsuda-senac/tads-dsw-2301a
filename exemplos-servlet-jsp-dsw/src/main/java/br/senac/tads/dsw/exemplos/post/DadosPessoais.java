package br.senac.tads.dsw.exemplos.post;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DadosPessoais {

    private Integer id;

    private String nome;

    private String descricao;

    private LocalDate dataNascimento;

    private String email;

    private String telefone;

    private String senha;

    private String senhaRepetida;

    private int numero;

    private BigDecimal altura;

    private BigDecimal peso;

    private int genero;

    private List<String> interesses;

    public DadosPessoais() {

    }

    public DadosPessoais(Integer id, String nome, String descricao, LocalDate dataNascimento,
            String email, String telefone, String senha, String senhaRepetida, int numero,
            BigDecimal altura, BigDecimal peso, int genero, List<String> interesses) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.senhaRepetida = senhaRepetida;
        this.numero = numero;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.interesses = interesses;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getSenhaRepetida() {
        return senhaRepetida;
    }

    public void setSenhaRepetida(String senhaRepetida) {
        this.senhaRepetida = senhaRepetida;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }
    
    public long getIdade() {
        if (this.dataNascimento != null) {
            return ChronoUnit.YEARS.between(this.dataNascimento, LocalDate.now());
        }
        return 0;
    }

    /*
     * IMC = peso / (altura * altura)
     * Magreza, quando o resultado é menor que 18,5 kg/m2;
     * Normal, quando o resultado está entre 18,5 e 24,9 kg/m2;
     * Sobrepeso, quando o resultado está entre 24,9 e 30 kg/m2;
     * Obesidade, quando o resultado é maior que 30 kg/m2.
     */
    public BigDecimal getImc() {
        BigDecimal basePeso = new BigDecimal(1).multiply(this.peso);
        BigDecimal baseAltura = new BigDecimal(1).multiply(this.altura).multiply(this.altura);
        if (this.peso != null && this.altura != null) {
            return basePeso.divide(baseAltura, RoundingMode.HALF_UP);
        }
        return new BigDecimal(0);
    }

    public String getImcTexto() {
        BigDecimal imc = getImc();
        if (imc.compareTo(new BigDecimal(0)) == 0) {
            return "NÃO CALCULADO";
        } else if (imc.compareTo(new BigDecimal("18.5")) == -1) {
            return "MAGREZA";
        } else if (imc.compareTo(new BigDecimal("24.9")) == -1) {
            return "NORMAL";
        } else if (imc.compareTo(new BigDecimal("30")) == -1) {
            return "SOBREPESO";
        }
        return "OBESIDADE";
    }

}
