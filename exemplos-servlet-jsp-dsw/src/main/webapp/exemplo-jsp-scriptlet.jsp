<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Exemplo JSP</title>
</head>
<body>
  <h1>Exemplo JSP + Scriptlet</h1>
  <%
        String texto = "abcd";
        texto = texto.toUpperCase();
        texto = texto + " / 12345678";
  %>
  <p>Data e hora atual: <%= LocalDateTime.now() %></p>
  <p>Texto gerado no Scriptlet: <%= texto %></p>
  <hr>
  <%
      for (int i = 0; i < 100; i++) {
  %>
  <p>Numero <%= i %></p>
  <%
      }
  %>
  
</body>
</html>
