package br.senac.tads.dsw.exemplos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping("/exemplos")
public class ExemploController {

    @GetMapping("/ex01") // Acesso MVC tradicional
    public String exemplo01() {
        return "teste";
    }

    @GetMapping("/ex02")
    @ResponseBody
    public String exemplo02() {
        return "teste";
    }

    @GetMapping("/ex03")
    @ResponseBody
    public String exemplo03() {
        return "{ \"nome\" : \"Fulano da Silva\", \"email\" : \"fulano@teste.com.br\" }";
    }
}
