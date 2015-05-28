<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<title>Consulta</title>
</head>
<body>

	<h3 class="titulo">Consulta de Clientes cadastrados.</h3>
	<a href="index.jsp">Inicial</a>
	&nbsp; | &nbsp;
	<a href="cadastrocliente.jsp">Cadastro</a>
	&nbsp; | &nbsp;
	<a href="controlecliente?acao=consulta">Consulta</a>
	<hr />
	<p />
	<b>${msg}</b>

	<table >
		<tr>
			<th colspan="10">Relação de Clientes cadastrados.</th>
		</tr>
		
		<tr>
			<th>Nome</th>
			<th>Código</th>
			<th>Ações</th>
		</tr>
		
		<c:forEach items="${listaCliente}" var="cliente">
			<tr class="produto_detalhe">
				<td>${cliente.nome}</td>
				<td>${cliente.codigo}</td>
				<td>
					<a href="controlecliente?acao=excluir&id=${cliente.idCliente}">Excluir</a>
					&nbsp; | &nbsp;
					<a href="controlecliente?acao=editar&id=${cliente.idCliente}">Editar</a>
				</td>
			</tr>
		</c:forEach>
				
	</table>

</body>
</html>