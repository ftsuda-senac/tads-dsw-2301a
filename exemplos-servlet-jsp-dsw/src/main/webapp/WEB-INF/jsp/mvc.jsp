<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><c:out value="${mensagem}" /></title>
</head>
<body>
  <h1><c:out value="${mensagem}" /></h1>
  <p>Data e hora atual: <c:out value="${dataHora}" /></p>
  <p>(método usado: <c:out value="${metodoHttp}" />)</p>
</body>
</html>
