package br.senac.tads.dsw.dadospessoais;

import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/senhas")
public class SenhaController {

    @PostMapping
    public String validarSenhas(@RequestBody @Valid Senha senha) {
        // return senha.getValor();
        return BCrypt.hashpw(senha.getValor(), BCrypt.gensalt());
    }

    @GetMapping("/comparar-hash")
    public String compararHash(@RequestParam String senha, @RequestParam String hash) {
        boolean senhaValida = BCrypt.checkpw(senha, hash);
        if (senhaValida) {
            return "OK";
        } else {
            return "INVALIDO";
        }
    }

}
