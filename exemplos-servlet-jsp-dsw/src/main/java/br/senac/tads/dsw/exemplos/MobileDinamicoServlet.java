package br.senac.tads.dsw.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MobileDinamicoServlet", urlPatterns = {"/mobile-dinamico"})
public class MobileDinamicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userAgent = request.getHeader("user-agent");
        String mensagem = "Acesso via dispositivo movel";
        String backgrondColor = "#2ecc71"; //Verde
        if (!userAgent.toLowerCase().contains("mobile")) {
            mensagem = "Acesso via desktop";
            backgrondColor = "#9b59b6"; // Roxo
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">");
            out.println("<title>Mobile - Exibição dinâmica</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: " + backgrondColor + ";\">");
            out.println("<h1>" + mensagem + "</h1>");
            out.println("<p>User agent: " + userAgent + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
