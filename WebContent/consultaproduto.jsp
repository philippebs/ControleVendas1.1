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

	<h3 class="titulo">Consulta produtos cadastrados.</h3>
	<a href="index.jsp">Inicial</a>
	&nbsp; | &nbsp;
	<a href="cadastroproduto.jsp">Cadastro</a>
	&nbsp; | &nbsp;
	<a href="controle?acao=consulta">Consulta</a>
	<hr />
	<p />
	<b>${msg}</b>

	<table >
		<tr>
			<th colspan="10">Relação de produtos cadastrados.</th>
		</tr>
		
		<tr>
			<th>Nome</th>
			<th>Valor</th>
			<th>Quantidade</th>
			<th>Ações</th>
		</tr>
		
		<c:forEach items="${listaProduto}" var="produto">
			<tr class="produto_detalhe">
				<td>${produto.nome}</td>
				<td>R$ ${produto.valor}</td>
				<td>${produto.quantidade}</td>
				<td>
					<a href="controle?acao=excluir&id=${produto.idProduto}">Excluir</a>
					&nbsp; | &nbsp;
					<a href="controle?acao=editar&id=${produto.idProduto}">Editar</a>
				</td>
			</tr>
		</c:forEach>
				
	</table>

</body>
</html>