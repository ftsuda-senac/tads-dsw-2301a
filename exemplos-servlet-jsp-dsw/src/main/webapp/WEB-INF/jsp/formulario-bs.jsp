<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Formulário</title>
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
      <section class="col-md-12">
        <h1>Formulário (Bootstrap)</h1>
        <form action="${pageContext.request.contextPath}/formulario-salvar" method="post" novalidate>
          <input type="hidden" name="id" value="${dados.id}" />
          <div class="row mb-3">
            <label for="txtNome" class="col-sm-2 col-form-label">Nome</label>
            <div class="col-sm-10">
              <input type="text" name="nome" class="form-control ${not empty erroNome ? 'is-invalid' : ''}" 
                id="txtNome" placeholder="Preencha o nome completo"
                value="${dados.nome}" required maxlength="100" />
              <c:if test="${not empty erroNome}">
                <div class="invalid-feedback"><c:out value="${erroNome}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtDescricao" class="col-sm-2 col-form-label">Descrição</label>
            <div class="col-sm-10">
              <textarea name="descricao" class="form-control" id="txtDescricao" 
                placeholder="Preencha um texto descritivo sobre sua pessoa">${dados.descricao}</textarea>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtDataNascimento" class="col-sm-2 col-form-label">Data de nascimento</label>
            <div class="col-sm-10">
              <input type="date" name="dataNascimento" class="form-control ${not empty erroDataNascimento ? 'is-invalid' : ''}"
                id="txtDataNascimento" value="${dados.dataNascimento}" />
              <c:if test="${not empty erroDataNascimento}">
                <div class="invalid-feedback"><c:out value="${erroDataNascimento}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtEmail" class="col-sm-2 col-form-label">E-mail</label>
            <div class="col-sm-10">
              <input type="email" name="email" class="form-control ${not empty erroEmail ? 'is-invalid' : ''}"
                id="txtEmail" placeholder="E-mail" value="${dados.email}"
                required maxlength="100"  />
              <c:if test="${not empty erroEmail}">
                <div class="invalid-feedback"><c:out value="${erroEmail}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtTelefone" class="col-sm-2 col-form-label">Telefone</label>
            <div class="col-sm-10">
              <input type="text" name="telefone" class="form-control"
                id="txtTelefone" placeholder="(99) 99999-9999" value="${dados.telefone}" 
                maxlength="16" />
            </div>
          </div>

          <div class="row mb-3">
            <label for="txtSenha" class="col-sm-2 col-form-label">Senha</label>
            <div class="col-sm-10">
              <input type="password" name="senha" class="form-control ${not empty erroSenha ? 'is-invalid' : ''}"
                id="txtSenha" placeholder="Senha" />
              <c:if test="${not empty erroSenha}">
                <div class="invalid-feedback"><c:out value="${erroSenha}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtSenhaRepetida" class="col-sm-2 col-form-label">Repetir senha</label>
            <div class="col-sm-10">
              <input type="password" name="senhaRepetida" class="form-control"
                id="txtSenhaRepetida" placeholder="Repetir senha" />
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtNumero" class="col-sm-2 col-form-label">Número de 1 a 99</label>
            <div class="col-sm-10">
              <input type="number" name="numero" class="form-control ${not empty erroNumero ? 'is-invalid' : ''}"
                id="txtNumero" placeholder="Número de 1 a 99" value="${dados.numero}"
                min="1" max="99" />
              <c:if test="${not empty erroNumero}">
                <div class="invalid-feedback"><c:out value="${erroNumero}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtAltura" class="col-sm-2 col-form-label">Altura</label>
            <div class="col-sm-10">
              <input type="number" name="altura" class="form-control ${not empty erroAltura ? 'is-invalid' : ''}"
                id="txtAltura" placeholder="Altura em metros com no máximo 2 casa decimais" value="${dados.altura}"
                min="0" max="3" step="0.01" />
              <c:if test="${not empty erroAltura}">
                <div class="invalid-feedback"><c:out value="${erroAltura}" /></div>
              </c:if>
            </div>
          </div>
          <div class="row mb-3">
            <label for="txtPeso" class="col-sm-2 col-form-label">Peso</label>
            <div class="col-sm-10">
              <input type="number" name="peso" class="form-control ${not empty erroPeso ? 'is-invalid' : ''}"
                id="txtPeso" placeholder="Peso em Kg com no máximo 1 casa decimal" value="${dados.peso}"
                min="0" max="500" step="0.1" />
              <c:if test="${not empty erroPeso}">
                <div class="invalid-feedback"><c:out value="${erroPeso}" /></div>
              </c:if>
            </div>
          </div>
          <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">Gênero</legend>
            <div class="col-sm-10">
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="genero" id="generoF" value="0" ${dados.genero == 0 ? 'checked' : ''} />
                <label class="form-check-label" for="generoF">Feminino</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="genero" id="generoM" value="1" ${dados.genero == 1 ? 'checked' : ''} />
                <label class="form-check-label" for="generoM">Masculino</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="genero" id="generoN" value="2" ${dados.genero == 2 ? 'checked' : ''} />
                <label class="form-check-label" for="generoN">Nenhum</label>
              </div>
            </div>
          </fieldset>
          <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">Interesses</legend>
            <div class="col-sm-10">
              <c:forEach items="${interesses}" var="interesse">
                <div class="form-check form-check-inline">
                  <input class="form-check-input ${not empty erroInteresses ? 'is-invalid' : ''}" type="checkbox" name="interesses" id="interesses${interesse}"
                      value="${interesse}" ${dados.interesses.contains(interesse) ? 'checked' : ''} />
                  <label class="form-check-label" for="interesses${interesse}"><c:out value="${interesse}" /> </label>
                </div>
              </c:forEach>
              <c:if test="${not empty erroInteresses}">
                <div class="invalid-feedback" style="display: block;"><c:out value="${erroInteresses}" /></div>
              </c:if>
            </div>
          </fieldset>
          <div class="row">
            <div class="col-md-3 offset-md-3">
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">Enviar</button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="d-grid">
                    <a href="#" role="button" class="btn btn-outline-dark">Cancelar</a>
                </div>
            </div>
          </div>
        </form>
      </section>
    </div>
  </main>
</body>
</html>