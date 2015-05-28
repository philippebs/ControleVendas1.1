<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<title>Cadastro</title>
</head>
<body>

	<h3 class="titulo">Cadastro Produtos</h3>
	<a href="index.jsp">Inicial</a>
	&nbsp; | &nbsp;
	<a href="cadastro.jsp">Cadastro</a>
	&nbsp; | &nbsp;
	<a href="controleproduto?acao=consulta">Consulta</a>
	<hr />
	<p />
	<b>${msg}</b>
	<form method="post" action="controleproduto?acao=cadastro"> 
		<fieldset>
			<legend>Informe os dados do cliente</legend>
			
			Nome:<br />
			<input type="text" name="nome" placeholder="Digite o nome" required="required" />
			<p />
			
			Quantidade:<br />
			<input type="text" name="quantidade" />
			<p />
			
			Valor:<br />
			<input type="text" name="valor" />
			<p />
			
			<!-- Sexo:<br />
			<select name="sexo" title="Informe o sexo">
				<option value="feminino">Feminino</option>
				<option value="masculino">Masculino</option>
			</select>
			<p />
			
			Nascimento:<br />
			<input type="date" name="dtnasc" title="Informe a Data de Nascimento" 
				required="required" />
			<p />
			
		</fieldset>
		 -->
		<input type="submit" value="Cadastrar" />
		<input type="reset" value="Limpar os campos" />
	</form>

</body>
</html>