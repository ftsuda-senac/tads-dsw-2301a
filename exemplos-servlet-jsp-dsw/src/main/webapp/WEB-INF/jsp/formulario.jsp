<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Formulárop</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body>
  <h1>Formulario</h1>
  <form action="${pageContext.request.contextPath}/formulario-salvar" method="post" novalidate>
    <input type="hidden" name="id" value="${dados.id}" />
    <div>
      <label>Nome</label>
        <input type="text" name="nome" placeholder="Preencha o nome completo" value="${dados.nome}"
        required maxlength="100" />
      <c:if test="${not empty erroNome}">
        <span class="msg-erro"><c:out value="${erroNome}" /></span>
      </c:if>
    </div>
    <div>
      <label>Descrição</label>
      <textarea name="descricao" placeholder="Preencha um texto descritivo sobre sua pessoa">${dados.descricao}</textarea>
    </div>
    <div>
      <label>Data de nascimento</label>
      <input type="date" name="dataNascimento" value="${dados.dataNascimento}" />
      <c:if test="${not empty erroDataNascimento}">
        <span class="msg-erro"><c:out value="${erroDataNascimento}" /></span>
      </c:if>
    </div>
    <div>
      <label>E-mail</label>
      <input type="email" name="email" value="${dados.email}" required maxlength="100" />
      <c:if test="${not empty erroEmail}">
        <span class="msg-erro"><c:out value="${erroEmail}" /></span>
      </c:if>
    </div>
    <div>
      <label>Telefone</label>
      <input type="text" name="telefone" value="${dados.telefone}" placeholder="(99) 99999-9999"
        maxlength="16"/>
    </div>
    <div>
      <label>Senha</label>
      <input type="password" name="senha" value="${dados.senha}" />
      <c:if test="${not empty erroSenha}">
        <span class="msg-erro"><c:out value="${erroSenha}" /></span>
      </c:if>
    </div>
    <div>
      <label>Repetir senha</label>
      <input type="password" name="senhaRepetida" value="${dados.senhaRepetida}" />
    </div>
    <div>
      <label>Número de 1 a 99</label>
      <input type="number" name="numero" value="${dados.numero}" min="1" max="99" />
      <c:if test="${not empty erroNumero}">
        <span class="msg-erro"><c:out value="${erroNumero}" /></span>
      </c:if>
    </div>
    <div>
      <label>Altura</label>
      <input type="number" name="altura" value="${dados.altura}" step="0.01" min="0" max="3" />
      <c:if test="${not empty erroAltura}">
        <span class="msg-erro"><c:out value="${erroAltura}" /></span>
      </c:if>
    </div>
    <div>
      <label>Peso</label>
      <input type="number" name="peso" value="${dados.peso}" step="0.1" min="0" max="500" />
      <c:if test="${not empty erroPeso}">
        <span class="msg-erro"><c:out value="${erroPeso}" /></span>
      </c:if>
    </div>
    <fieldset>
      <legend>Gênero</legend>
      <div>
        <input type="radio" name="genero" value="0" id="generoF" ${dados.genero == 0 ? 'checked' : ''} />
        <label for="generoF">Feminino</label>
      </div>
      <div>
        <input type="radio" name="genero" value="1" id="generoM" ${dados.genero == 1 ? 'checked' : ''} />
        <label for="generoM">Masculino</label>
      </div>
      <div>
        <input type="radio" name="genero" value="2" id="generoN" ${dados.genero == 2 ? 'checked' : ''} />
        <label for="generoN">Nenhum</label>
      </div>
    </fieldset>
    <fieldset>
      <legend>Interesses</legend>
      <c:forEach items="${interesses}" var="interesse">
        <div>
          <input type="checkbox" name="interesses" value="${interesse}" id="interesse${interesse}"
            ${dados.interesses.contains(interesse) ? "checked" : ''} />
            <label for="interesse${interesse}"><c:out value="${interesse}" /></label>
        </div>
      </c:forEach>
      <c:if test="${not empty erroInteresses}">
        <span class="msg-erro"><c:out value="${erroInteresses}" /></span>
      </c:if>
    </fieldset>
    <button type="submit">Enviar</button>
  </form>
</body>
</html>
