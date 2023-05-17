package br.senac.tads.dsw.dadospessoais;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService service;

    @GetMapping
    public List<DadosPessoaisDto> findAll(
            @RequestParam(value = "pagina", defaultValue="0") int pagina,
            @RequestParam(value = "quantidade", defaultValue="5") int quantidade,
            @RequestParam(value = "textoBusca", required = false) String textoBusca
    ) {
        return service.findAll(pagina, quantidade, textoBusca);
    }

    @GetMapping("/{apelido}")
    public DadosPessoaisDto findByApelido(@PathVariable String apelido) {
        return service.findByApelido(apelido);
    }

    @PostMapping
    public ResponseEntity<Void> addNew(@RequestBody DadosPessoaisDto dados) {
        service.addNew(dados);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{apelido}")
                .buildAndExpand(dados.getApelido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{apelido}")
    public ResponseEntity<Void> update(
            @PathVariable String apelido,
            @RequestBody DadosPessoaisDto dados) {
        service.update(apelido, dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{apelido}")
    public ResponseEntity<Void> delete(@PathVariable String apelido) {
        service.delete(apelido);
        return ResponseEntity.ok().build();
    }

}
