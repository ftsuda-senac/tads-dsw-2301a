package br.senac.tads.dsw.exemplos;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class ExemploRestController {

    @GetMapping("/ex02")
    public String exemplo02() {
        return "teste rest xxxxx";
    }

    @GetMapping("/ex03")
    public String exemplo03() {
        return "{ \"nome\" : \"Fulano da Silva\", \"email\" : \"fulano@teste.com.br\" }";
    }

    @GetMapping("/ex03plus")
    public DadosPessoais exemplo03Plus() {
        DadosPessoais dados = new DadosPessoais();
        dados.setNome("Fulano da Silva");
        dados.setApelido("fulano");
        dados.setEmail("fulano@teste.com.br");
        dados.setTelefone("(11) 99988-1122");
        dados.setDataNascimento(LocalDate.of(2000,10,20));
        List<String> conhecimentos = new ArrayList<>();
        conhecimentos.add("Java");
        conhecimentos.add("HTML");
        conhecimentos.add("CSS");
        conhecimentos.add("Javascript");
        dados.setConhecimentos(conhecimentos);
        return dados;
    }

    @GetMapping("/ex04")
    public DadosPessoais exemplo04(
            @RequestParam("nome") String nome,
            @RequestParam(value = "apelido", defaultValue = "Vacilao") String apelido,
            @RequestParam(value = "dataNascimento", required = false) String dataNascimentoStr) {
        DadosPessoais dados = new DadosPessoais();
        dados.setNome(nome);
        dados.setApelido(apelido);
        dados.setEmail(apelido + "@teste.com.br");
        dados.setTelefone("(11) 99876-0987");
        if (dataNascimentoStr != null && dataNascimentoStr.length() > 0) {
            dados.setDataNascimento(LocalDate.parse(dataNascimentoStr));
        }

        dados.setConhecimentos(Arrays.asList("Java", "Docker", "AWS"));
        return dados;
    }

    @GetMapping("/ex05/{apelido}")
    public DadosPessoais exemplo05(
            @PathVariable("apelido") String apelido,
            @RequestParam(required = false) String nome) {
        DadosPessoais dados = new DadosPessoais();
        if (nome != null) {
            dados.setNome(nome);
        } else {
            dados.setNome(apelido + " de Souza");
        }
        dados.setApelido(apelido);
        dados.setEmail(apelido + "@teste.com.br");
        dados.setTelefone("(11) 99876-0987");
        dados.setDataNascimento(LocalDate.parse("2001-03-08"));
        dados.setConhecimentos(Arrays.asList("Python", "Perl", "Ruby"));
        return dados;
    }

    @GetMapping("/user-agent")
    public String exUserAgent(@RequestHeader("user-agent") String userAgent) {
        return userAgent;
    }

    @GetMapping("/cabecalhos")
    public Map<String, String> exCabecalhos(@RequestHeader Map<String, String> cabecalhosHttp) {
        return cabecalhosHttp;
    }
}
