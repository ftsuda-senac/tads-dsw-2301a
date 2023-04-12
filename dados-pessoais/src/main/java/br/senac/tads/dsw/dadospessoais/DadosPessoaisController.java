package br.senac.tads.dsw.dadospessoais;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    private Map<String, DadosPessoais> mapPessoas;

    public DadosPessoaisController() {
        mapPessoas = new LinkedHashMap<>();
        DadosPessoais dados = new DadosPessoais("Fulano da Silva", "fulano", "fulano@teste.com.br", "(11) 99901-0909", "Abcd$1234", LocalDate.parse("2000-10-20"), Arrays.asList("Java", "HTML", "CSS", "Javascript"));
        mapPessoas.put(dados.getApelido(), dados);
    }


    @GetMapping
    public List<DadosPessoais> listar() {
        return new ArrayList<>(mapPessoas.values());
    }

    @GetMapping("/{apelido}")
    public DadosPessoais buscarPorApelido(@PathVariable String apelido) {
        return mapPessoas.get(apelido);
    }

    @PostMapping(consumes = "application/json")
    public DadosPessoais incluirNovo(@RequestBody DadosPessoais dados) {
        mapPessoas.put(dados.getApelido(), dados);
        return dados;
    }
}
