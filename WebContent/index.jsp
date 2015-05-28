<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<title>Inicial</title>
</head>
<body>

	<h3 class="titulo">Controle de vendas.</h3>
	<a href="cadastroproduto.jsp">Cadastro Produto</a>
	&nbsp; | &nbsp;
	<a href="controleproduto?acao=consulta">Consulta Produto</a>
	&nbsp; | &nbsp;
	<a href="cadastrocliente.jsp">Cadastro Cliente</a>
	&nbsp; | &nbsp;
	<a href="controlecliente?acao=consulta">Consulta Cliente</a>
	&nbsp; | &nbsp;
	<a href="controlecliente?acao=consultaclientepedido">Cadastro Pedido</a>
	&nbsp; | &nbsp;
	<hr />
	<p />
	<form action="" method="post">
		Login:
		<input type="text" name="login" />
		<br />
		
		Senha:
		<input type="password" name="senha" />
		<br />
		
		<input type="submit" value="Logar" />
	</form>
	
</body>
</html>