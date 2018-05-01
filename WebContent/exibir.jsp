<%@ page import="br.com.iesp.projeto.repository.ClienteRepository" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Users</title>
</head>
<body>
	<table>
		<tr>
			<th>Login</th>
			<th>Senha</th>
			<c:forEach var="clientes" items="${listaCliente}">
				<tr>
					<td>${clientes.user}</td>
					<td>${clientes.passwd}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>