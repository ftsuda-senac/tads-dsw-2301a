package br.senac.tads.dsw.dadospessoais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conhecimentos")
public class ConhecimentoController {

    @Autowired
    private ConhecimentoRepository repositorio;

    @GetMapping
    public List<Conhecimento> findAll() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Conhecimento findById(@PathVariable Integer id) {
        Optional<Conhecimento> optConhecimento = repositorio.findById(id);
        if (optConhecimento.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "ID " + id + " não encontrado");
        }
        Conhecimento c = optConhecimento.get();
        return c;
    }

    @PostMapping
    public ResponseEntity<Void> incluirNovo(@RequestBody Conhecimento c) {
        repositorio.save(c);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable  Integer id,
                                          @RequestBody Conhecimento c) {
        Optional<Conhecimento> optConhecimento = repositorio.findById(id);
        if (optConhecimento.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "ID " + id + " não encontrado");
        }
        c.setId(id);
        repositorio.save(c);
        return ResponseEntity.ok().build();
    }
}
