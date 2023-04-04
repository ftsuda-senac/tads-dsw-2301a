/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package br.senac.tads.dsw.exemplos.post;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FormularioSalvarServlet", urlPatterns = {"/formulario-salvar"})
public class FormularioSalvarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String senhaRepetida = request.getParameter("senhaRepetida");
        String numeroStr = request.getParameter("numero");
        String alturaStr = request.getParameter("altura");
        String pesoStr = request.getParameter("peso");
        String generoStr = request.getParameter("genero");
        String[] interessesArr = request.getParameterValues("interesses");

        // VALIDACOES E CONVERSÕES
        boolean temErro = false;

        Integer id = null;
        if (idStr != null && idStr.trim().length() > 0) {
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                // Mantém id null
            }
        }

        if (nome == null || nome.trim().length() == 0) {
            temErro = true;
            request.setAttribute("erroNome", "Nome não preenchido");
        }

        if (email == null || email.trim().length() == 0) {
            temErro = true;
            request.setAttribute("erroEmail", "E-mail não preenchido");
        }

        LocalDate dataNascimento = null;
        if (dataNascimentoStr != null && dataNascimentoStr.trim().length() > 0) {
            try {
                dataNascimento = LocalDate.parse(dataNascimentoStr);
                if (dataNascimento.isAfter(LocalDate.now())) {
                    // ERRO - dataNascimento no futuro;
                    temErro = true;
                    request.setAttribute("erroDataNascimento",
                            "Data de nascimento inválida - está no futuro");
                }
            } catch (DateTimeParseException ex) {
                // Mantém dataNascimento null
                temErro = true;
                request.setAttribute("erroDataNascimento",
                        "Data de nascimento inválida - formato inválido");
            }
        }

        if (senha != null && senha.trim().length() > 0) {
            if (!senha.equals(senhaRepetida)) {
                temErro = true;
                request.setAttribute("erroSenha", "Senha e repetição são diferentes");
            }
        } else {
            temErro = true;
            request.setAttribute("erroSenha", "O preenchimento da senha é obrigatório");
        }

        int numero = 0;
        if (numeroStr != null && numeroStr.trim().length() > 0) {
            try {
                numero = Integer.parseInt(numeroStr);
                if (numero < 1) {
                    temErro = true;
                    request.setAttribute("erroNumero", "Número é menor do que 1");
                } else if (numero > 99) {
                    temErro = true;
                    request.setAttribute("erroNumero", "Número é maior do que 99");
                }
            } catch (NumberFormatException ex) {
                temErro = true;
                request.setAttribute("erroNumero", "Valor informado é inválido");
            }
        } else {
            temErro = true;
            request.setAttribute("erroNumero", "Número não preenchido");
        }

        BigDecimal altura = null;
        if (alturaStr != null && alturaStr.trim().length() > 0) {
            try {
                altura = new BigDecimal(alturaStr);
            } catch (NumberFormatException ex) {
                // Mantem altura null
            }
        }

        BigDecimal peso = null;
        if (pesoStr != null && pesoStr.trim().length() > 0) {
            try {
                peso = new BigDecimal(pesoStr);
            } catch (NumberFormatException ex) {
                // Mantem altura null
            }
        }
        int genero = -1;
        try {
            genero = Integer.parseInt(generoStr);
        } catch (NumberFormatException ex) {
            // Mantem genero com valor invalido
        }
        
        List<String> interesses = null;
        if (interessesArr != null && interessesArr.length > 0) {
            interesses = Arrays.asList(interessesArr);
        } else {
            temErro = true;
            request.setAttribute("erroInteresses", "Pelo menos um interesse deve ser escolhido");
        }

        DadosPessoais dados = new DadosPessoais(id, nome, descricao, dataNascimento, email,
                telefone, senha, senhaRepetida, numero, altura, peso, genero,
                interesses);

        request.setAttribute("dados", dados);

        // Verificar se houve algum erro na validação
        if (temErro) {
            List<String> interessesOpcoes = Arrays.asList("Tecnologia", "Gastronomia", "Viagens",
                    "Esportes", "Investimentos");
            request.setAttribute("interesses", interessesOpcoes);
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/formulario-bs.jsp");
            dispatcher.forward(request, response);
        } else {
            // ***** FAZ FORWARD DIRETO PARA RESULTADO
            // APÓS A TELA APARECER, TENTAR ATUALIZAR NO BROWSER
            //RequestDispatcher dispatcher =
            //request.getRequestDispatcher("/WEB-INF/jsp/resultado-bs.jsp");
            //dispatcher.forward(request, response);

            // **** POST-REDIRECT-GET
            HttpSession sessao = request.getSession();
            sessao.setAttribute("dados", dados);
            response.sendRedirect(request.getContextPath() + "/resultado");
        }

    }

}
