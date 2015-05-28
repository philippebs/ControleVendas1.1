<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<title>Cadastro de Pedido</title>
</head>
<body>
	
	<h3 class="titulo">Cadastro Cliente</h3>
	<a href="index.jsp">Inicial</a>
	&nbsp; | &nbsp;
	<a href="cadastrocliente.jsp">Cadastro</a>
	&nbsp; | &nbsp;
	<a href="controlecliente?acao=consulta">Consulta</a>
	<hr />
	<p />
	<b>${msg}</b>
	
	<form action="controlecliente?acao=cadastro" method="post">
		
		Código:<br />
		<input type="text" name="codigo" placeholder="Digite o codigo do pedido" />
		<p />
		
		Cliente:<br />
		<select name="cliente">
			<c:forEach items="${listaCliente}" var="cliente">
				<option value="${cliente.idCliente}" id="cliente">${cliente.nome}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Cadastrar" />
		<input type="reset" value="Limpar os campos" />
	</form>
	
</body>
</html>