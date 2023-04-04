<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Formas de acessar informações</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<style>
.scheme {
  color: #2980b9
}

.server-name {
  color: #16a085
}

.server-port {
  color: #f39c12
}

.context-path {
  color: #c0392b
}

.servlet-path {
  color: #8e44ad
}

.path-info {
  color: #888
}

.query-string {
  color: #95a5a6
}
</style>
</head>
<body>
  <h1>Métodos/Expressões HttpServletRequest</h1>
  <h2>Formas de acessar as diversas informações da requisição</h2>
  <%--
        <h2>URL chamada: <code>${pageContext.request.requestURL}<c:if 
              test="${not empty pageContext.request.parameterMap}">?${pageContext.request.queryString}</c:if>
            </code></h2>
        --%>
  <h3>
    URL chamada:<br />
    <code>
      <span class="scheme">${pageContext.request.scheme}</span>://<span class="server-name">${pageContext.request.serverName}</span>:<span
        class="server-port">${pageContext.request.serverPort}</span><span class="context-path">${pageContext.request.contextPath}</span><span
        class="servlet-path"><c:choose>
          <c:when test="${not empty requestScope['javax.servlet.forward.servlet_path']}">${requestScope['javax.servlet.forward.servlet_path']}</c:when>
          <c:otherwise>${pageContext.request.servletPath}</c:otherwise>
        </c:choose></span><span class="path-info"><c:choose>
          <c:when test="${not empty requestScope['javax.servlet.forward.path_info']}">${requestScope['javax.servlet.forward.path_info']}</c:when>
          <c:otherwise>${pageContext.request.pathInfo}</c:otherwise>
        </c:choose></span>
      <c:if test="${not empty pageContext.request.queryString}">?<span class="query-string"><c:out
            value="${pageContext.request.queryString}" /></span>
      </c:if>
    </code>
  </h3>
  <table class="table">
    <thead>
      <tr>
        <th>&nbsp;</th>
        <th>Método Servlet</th>
        <th>EL no JSP</th>
        <th>Valor</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>method</th>
        <td><code>request.getMethod()</code></td>
        <td><code>${'${pageContext.request.method}'}</code></td>
        <td>${pageContext.request.method}</td>
      </tr>
      <tr>
        <th>protocol</th>
        <td><code>request.getProtocol()</code></td>
        <td><code>${'${pageContext.request.protocol}'}</code></td>
        <td>${pageContext.request.protocol}</td>
      </tr>
      <tr>
        <th>scheme</th>
        <td><code>request.getScheme()</code></td>
        <td><code>${'${pageContext.request.scheme}'}</code></td>
        <td class="scheme">${pageContext.request.scheme}</td>
      </tr>
      <tr>
        <th>server name</th>
        <td><code>request.getServerName()</code></td>
        <td><code>${'${pageContext.request.serverName}'}</code></td>
        <td class="server-name">${pageContext.request.serverName}</td>
      </tr>
      <tr>
        <th>server port</th>
        <td><code>request.getServerPort()</code></td>
        <td><code>${'${pageContext.request.serverPort}'}</code></td>
        <td class="server-port">${pageContext.request.serverPort}</td>
      </tr>
      <tr>
        <th>context path</th>
        <td><code>request.getContextPath()</code></td>
        <td><code>${'${pageContext.request.contextPath}'}</code></td>
        <td class="context-path">${pageContext.request.contextPath}</td>
      </tr>
      <tr>
        <th>servlet path</th>
        <td><code>request.getServletPath()</code></td>
        <td><code>${'${pageContext.request.servletPath}'}</code></td>
        <td class="servlet-path">${pageContext.request.servletPath}</td>
      </tr>
      <tr>
        <th>servlet path original<br />(após forward do Servlet para JSP)
        </th>
        <td><code>request.getAttribute("javax.servlet.forward.servlet_path")</code></td>
        <td><code>${'${requestScope[\'javax.servlet.forward.servlet_path\']}'}</code></td>
        <td class="servlet-path">${requestScope['javax.servlet.forward.servlet_path']}</td>
      </tr>
      <tr>
        <th>path info</th>
        <td><code>request.getPathInfo()</code></td>
        <td><code>${'${pageContext.request.pathInfo}'}</code></td>
        <td class="path-info">${pageContext.request.pathInfo}</td>
      </tr>
      <tr>
        <th>path info original<br />(após forward do Servlet para JSP)
        </th>
        <td><code>request.getAttribute("javax.servlet.forward.path_info")</code></td>
        <td><code>${'${requestScope[\'javax.servlet.forward.path_info\']}'}</code></td>
        <td class="path-info">${requestScope['javax.servlet.forward.path_info']}</td>
      </tr>
      <tr>
        <th>request URI</th>
        <td><code>request.getRequestURI()</code></td>
        <td><code>${'${pageContext.request.requestURI}'}</code></td>
        <td>${pageContext.request.requestURI}</td>
      </tr>
      <tr>
        <th>request URI original<br />(após forward do Servlet para JSP)
        </th>
        <td><code>request.getAttribute("javax.servlet.forward.request_uri")</code></td>
        <td><code>${'${requestScope[\'javax.servlet.forward.request_uri\']}'}</code></td>
        <td>${requestScope['javax.servlet.forward.request_uri']}</td>
      </tr>
      <tr>
        <th>query string</th>
        <td><code>request.getQueryString()</code></td>
        <td><code>${'${pageContext.request.queryString}'}</code></td>
        <td class="query-string"><c:out value="${pageContext.request.queryString}" /></td>
      </tr>
      <tr>
        <th>Parâmetros</th>
        <td><code>request.getParameterMap()</code></td>
        <td><code>${'${pageContext.request.parameterMap}'}</code></td>
        <td><c:if test="${not empty pageContext.request.parameterMap}">
            <table>
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${pageContext.request.parameterMap}" var="p">
                  <tr>
                    <td>${p.key}:&nbsp;</td>
                    <td>
                      <c:forEach items="${p.value}" var="val">
                        <span>${val}</span>&nbsp;
                      </c:forEach></td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </c:if></td>
      </tr>
    </tbody>
  </table>
  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <h2>Teste de GET</h2>
        <h3>Clique no link para enviar parametros na URL e veja como os valores ficam na tabela acima</h3>
        <a href="${pageContext.request.contextPath}/metodos-request-servlet?parametro1=abc&parametro2=xyz&parametro3=123">[URL]?parametro1=abc&#38;parametro2=xyz&#38;parametro3=123</a>
        <hr />
        <h2>Teste de POST</h2>
        <h3>Preencha o formulário e veja como os valores ficam na tabela acima</h3>
        <form action="${pageContext.request.contextPath}/metodos-request-servlet" method="post">
          <input type="hidden" name="campo-hidden" value="123" />
          <div class="form-group">
            <label>Nome completo</label> <input type="text" name="nome" class="form-control" />
          </div>
          <div class="form-group">
            <label>E-mail</label> <input type="email" name="email" class="form-control" />
          </div>
          <div class="form-group">
            <label>Senha</label> <input type="password" name="senha" class="form-control" />
          </div>
          <button type="submit" class="btn btn-default">Enviar</button>
        </form>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <h2>Cabeçalhos (headers) enviados pelo navegador</h2>
        <ul>
          <c:forEach items="${pageContext.request.headerNames}" var="headerName">
            <li><c:out value="${headerName}" />: <c:out value="${header[headerName]}" /></li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <hr />
    <div class="row">
      <div class="col-sm-12">
        <p>
          Remote addr:
          <code>${pageContext.request.remoteAddr}</code>
        </p>
        <p>
          Remote host:
          <code>${pageContext.request.remoteHost}</code>
        </p>
        <p>
          Remote port:
          <code>${pageContext.request.remotePort}</code>
        </p>
        <p>
          Local addr:
          <code>${pageContext.request.localAddr}</code>
        </p>
        <p>
          Local name:
          <code>${pageContext.request.localName}</code>
        </p>
        <p>
          Local port:
          <code>${pageContext.request.localPort}</code>
        </p>
      </div>
    </div>
  </div>
</body>
</html>
