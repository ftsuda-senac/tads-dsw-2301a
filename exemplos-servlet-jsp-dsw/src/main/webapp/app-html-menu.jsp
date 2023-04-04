<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Exemplo JSP</title>
</head>
<body>
  <h1>Exemplo App HTML</h1>
  <p>Comparar funcionamento com o AppConsole.java</p>
  <p>Opções</p>
  <ul>
    <li>1) Texto simples: <a href="${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=1">${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=1</a></li>
    <li>2) HTML: <a href="${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=2">${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=2</a></li>
    <li>3) JSON: <a href="${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=3">${pageContext.request.contextPath}${requestScope['javax.servlet.forward.servlet_path']}?opcao=3</a></li>
  </ul>
  
  <p>Data e hora atual: <%= LocalDateTime.now() %></p>
</body>
</html>
