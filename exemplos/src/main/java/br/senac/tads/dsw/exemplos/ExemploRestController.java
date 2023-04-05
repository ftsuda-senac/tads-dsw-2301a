package br.senac.tads.dsw.exemplos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ExemploRestController {

    @GetMapping("/ex02")
    public String exemplo02() {
        return "teste rest xxxxx";
    }
}
