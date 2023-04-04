<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Resultado</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/all.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/animate.css@4.1.1/animate.min.css" />
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
  <main class="container">
    <div class="row">
      <c:choose>
        <c:when test="${dados != null}">
          <section class="col-md-12">
            <h2>Dados preenchidos</h2>
            <div>
              ID: <span><c:out value="${dados.id}" /></span>
            </div>
            <div>
              Nome: <span><c:out value="${dados.nome}" /></span>
            </div>
            <div>
              Descrição: <span><c:out value="${dados.descricao}" /></span>
            </div>
            <div>
              Data nascimento: <span><c:out value="${dados.dataNascimento}" /></span>
            </div>
            <div>
              Idade: <span><c:out value="${dados.idade}" /></span>
            </div>
            <div>
              E-mail: <span><c:out value="${dados.email}" /></span>
            </div>
            <div>
              Telefone: <span><c:out value="${dados.telefone}" /></span>
            </div>
            <div>
              Senha: <span><c:out value="${dados.senha}" /></span>
            </div>
            <div>
              Senha repetida: <span><c:out value="${dados.senhaRepetida}" /></span>
            </div>
            <div>
              Número: <span><c:out value="${dados.numero}" /></span>
            </div>
            <div>
              Altura: <span><c:out value="${dados.altura}" /></span>
            </div>
            <div>
              Peso: <span><c:out value="${dados.peso}" /></span>
            </div>
            <div>
              IMC: <span><c:out value="${dados.imc}" />&nbsp;(<em><c:out value="${dados.imcTexto}" /></em>)</span>
            </div>
            <div>
              Gênero: <span>
                <c:choose>
                  <c:when test="${dados.genero == 0}">Feminino</c:when>
                  <c:when test="${dados.genero == 1}">Masculino</c:when>
                  <c:otherwise>Nenhum</c:otherwise>
                </c:choose>
              </span>
            </div>
            <div>
              Interesses:
              <c:choose>
                <c:when test="${dados.interesses != null && !dados.interesses.isEmpty()}">
                  <ul>
                    <c:forEach items="${dados.interesses}" var="interesse">
                      <li><c:out value="${interesse}" /></li>
                    </c:forEach>
                  </ul>
                </c:when>
                <c:otherwise><span>Nenhum selecionado</span></c:otherwise>
              </c:choose>
            </div>
          </section>
        </c:when>
        <c:otherwise>
          <section class="col-md-12">
            <h4>Não há dados para serem exibidos</h4>
          </section>
        </c:otherwise>
      </c:choose>
    </div>
    <div class="row">
      <div class="col-md-4 offset-md-4">
        <div class="d-grid">
            <a href="${pageContext.request.contextPath}/formulario" role="button" class="btn btn-primary">Voltar para formulário</a>
        </div>
      </div>
    </div>
  </main>
</body>
</html>