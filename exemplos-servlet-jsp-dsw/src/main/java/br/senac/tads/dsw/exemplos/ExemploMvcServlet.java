/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package br.senac.tads.dsw.exemplos;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExemploMvcServlet", urlPatterns = {"/exemplo-mvc"})
public class ExemploMvcServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("mensagem", "Exemplo MVC - Servlet + JSP");
        request.setAttribute("dataHora", LocalDateTime.now());
        request.setAttribute("metodoHttp", "GET");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mvc.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("mensagem", "Exemplo MVC - Servlet + JSP");
        request.setAttribute("dataHora", LocalDateTime.now());
        request.setAttribute("metodoHttp", "POST");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mvc.jsp");
        dispatcher.forward(request, response);
    }

}
