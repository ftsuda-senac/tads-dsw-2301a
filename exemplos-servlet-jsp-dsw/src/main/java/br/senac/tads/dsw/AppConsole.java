package br.senac.tads.dsw;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AppConsole {
    
    public String gerarTexto() {
        return "Texto gerado - Data e hora: " + LocalDateTime.now();
    }
    
    public String gerarHtml() {
         return "<!DOCTYPE html>" + System.lineSeparator()
                 + "<html>" + System.lineSeparator()
                 + "<head>" + System.lineSeparator()
                 + "\t<meta charset=\"UTF-8\" />" + System.lineSeparator()
                 + "\t<title>Exemplo HTML</title>" + System.lineSeparator()
                 + "</head>" + System.lineSeparator()
                 + "<body>" + System.lineSeparator()
                 + "\t<h1>Exemplo HTML gerado por classe Java</h1>" + System.lineSeparator()
                 + "\t<p>Data e hora: " + LocalDateTime.now() + "</p>" + System.lineSeparator()
                 + "</body>" + System.lineSeparator()
                 + "</html>";
    }

    public String gerarJson() {
        return "{" + System.lineSeparator()
                + "\t\"texto\" : \"Exemplo JSON gerado por classe Java\"," + System.lineSeparator()
                + "\t\"dataHora\" : \"" + LocalDateTime.now() + "\"" + System.lineSeparator()
                + "}";
    }

    private static void mostrarMenu() {
        System.out.println("Digite a opção desejada:");
        System.out.println("(1) Gerar texto");
        System.out.println("(2) Gerar HTML");
        System.out.println("(3) Gerar JSON");
        System.out.println("(9) Sair");
    }

    public static void main(String[] args) {
        AppConsole app = new AppConsole();
        try (Scanner in = new Scanner(System.in)) {
            do {
                mostrarMenu();
                try {
                    int opcao = in.nextInt();
                    String resposta;
                    switch (opcao) {
                        case 1:
                            resposta = app.gerarTexto();
                            System.out.println(resposta);
                            break;
                        case 2:
                            resposta = app.gerarHtml();
                            System.out.println(resposta);
                            break;
                        case 3:
                            resposta = app.gerarJson();
                            System.out.println(resposta);
                            break;
                        case 9:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } catch (Exception ex) {
                    System.out.println("Opção inválida - " + ex.getMessage());
                }
            } while (true);
        }
    }

}
