package br.senac.tads.dsw.exemplos.post;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormularioServlet", urlPatterns = {"/formulario"})
public class FormularioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> interesses =
                Arrays.asList("Tecnologia", "Gastronomia", "Viagens", "Esportes", "Investimentos");
        request.setAttribute("interesses", interesses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formulario-bs.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
