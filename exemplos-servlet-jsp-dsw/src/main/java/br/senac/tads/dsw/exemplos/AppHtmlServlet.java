/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AppHtmlServlet", urlPatterns = "/app-html")
public class AppHtmlServlet extends HttpServlet {

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
                + "\t<h1>Exemplo HTML gerado no Servlet</h1>" + System.lineSeparator()
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String opcao = request.getParameter("opcao");

        String resposta;
        if ("1".equals(opcao)) {
            response.setContentType("text/plain");
            resposta = gerarTexto();
        } else if ("2".equals(opcao)) {
             response.setContentType("text/html");
             resposta = gerarHtml();
        } else if ("3".equals(opcao)) {
            response.setContentType("application/json");
            resposta = gerarJson();
        } else {
            // Mostra menu caso nenhuma opção seja selecionada
            RequestDispatcher dispatcher = request.getRequestDispatcher("/app-html-menu.jsp");
            dispatcher.forward(request, response);
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println(resposta);
        }
    }

}
