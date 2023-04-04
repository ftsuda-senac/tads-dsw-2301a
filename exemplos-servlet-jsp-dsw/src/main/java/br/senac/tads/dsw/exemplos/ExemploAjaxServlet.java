package br.senac.tads.dsw.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExemploAjaxServlet", urlPatterns = {"/exemplo-ajax-servlet"})
public class ExemploAjaxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println("{ \"dataHora\": \"" + LocalDateTime.now() + "\" }");
        }
    }

}
