package br.senac.tads.dsw.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalcularIdadeServlet", urlPatterns = "/calcular-idade")
public class CalcularIdadeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CalcularIdadeService calcIdade = new CalcularIdadeService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String valorRecebido = request.getParameter("nome");
        String dataRecebida = request.getParameter("data");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\" />");
            out.println("<title>Calcular idade</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calcular idade</h1>");
            out.println("<h2>Nome: " + valorRecebido + "</h2>");
            if (dataRecebida != null) {
                out.println("<h2>Data nascimento: " + dataRecebida + "</h2>");
                long idade = calcIdade.calcular(dataRecebida);
                out.println("<h2>Idade: " + idade + "</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
