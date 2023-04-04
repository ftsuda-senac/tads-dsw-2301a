package br.senac.tads.dsw.exemplos.post;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ResultadoServlet", urlPatterns = {"/resultado"})
public class ResultadoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("dados") != null) {
            DadosPessoais dados = (DadosPessoais) sessao.getAttribute("dados");
            sessao.removeAttribute("dados");
            request.setAttribute("dados", dados);
        } else {
            // TODO: IMPLEMENTAR LÓGICA DE ERRO
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/resultado-bs.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
