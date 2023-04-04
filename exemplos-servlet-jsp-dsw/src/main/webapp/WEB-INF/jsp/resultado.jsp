<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Resultado</title>
</head>
<body>
  <div>
    <h1>Dados preenchidos</h1>
    <p>
      ID: <span><c:out value="${dados.id}" /></span>
    </p>
    <p>
      Nome: <span><c:out value="${dados.nome}" /></span>
    </p>
    <p>
      Descrição: <span><c:out value="${dados.descricao}" /></span>
    </p>
    <p>
      Data de nascimento: <span><c:out value="${dados.dataNascimento}" /></span>
    </p>
    <p>
      Idade: <span><c:out value="${dados.idade}" /></span>
    </p>
    <p>
      E-mail: <span><c:out value="${dados.email}" /></span>
    </p>
    <p>
      Telefone: <span><c:out value="${dados.telefone}" /></span>
    </p>
    <p>
      Senha: <span><c:out value="${dados.senha}" /></span>
    </p>
    <p>
      Senha repetida: <span><<c:out value="${dados.senhaRepetida}" /></span>
    </p>
    <p>
      Número: <span><c:out value="${dados.numero}" /></span>
    </p>
    <p>
      Altura: <span><c:out value="${dados.altura}" /></span>
    </p>
    <p>
      Peso: <span><c:out value="${dados.peso}" /></span>
    </p>
    <p>
      IMC: <span><c:out value="${dados.imc}" /></span>
    </p>
    <p>
      Gênero: <span><c:out value="${dados.genero}" /></span>
    </p>
    <div>
      Interesses:
      <ul>
        <c:forEach items="${dados.interesses}" var="interesse">
          <li><c:out value="${interesse}" /></li>
        </c:forEach>
      </ul>
    </div>
    <a href="${pageContext.request.contextPath}/formulario">Voltar para formulário</a>
  </div>
</body>
</html>
