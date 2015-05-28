<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Alterar dados do Cliente.</h3>
	<a href="index.jsp">Inicial</a>
	&nbsp; | &nbsp;
	<a href="cadastro.jsp">Cadastro</a>
	&nbsp; | &nbsp;
	<a href="controle?acao=consulta">Consulta</a>
	<hr />
	<p />
	<b>${msg}</b>
	<form method="post" action="controle?acao=alterar"> 
		<fieldset>
			<legend>Informe os dados do cliente</legend>
			
			Id:<br />
			<input type="text" name="idcli" value="${cliente.idCliente}" readonly="readonly" />
			<p />
			
			Nome:<br />
			<input type="text" name="nome" value="${cliente.nome}" required="required" />
			<p />
			
			CPF:<br />
			<input type="text" name="cpf" value="${cliente.cpf}" required="required"
				pattern="\d{3}\.\d{3}\.\d{3}\-\d{2}" title="Formato CPF: 999.999.999-99" />
			<p />
			
			Email:<br />
			<input type="email" name="email" value="${cliente.email}" required="required" />
			<p />
			
			Sexo:<br />
			<select name="sexo" title="Informe o sexo">
			<c:choose>
				<c:when test="${cliente.sexo == 'feminino'}">
					<option value="feminino">Feminino</option>
					<option value="masculino">Masculino</option>
				</c:when>
				<c:when test="${cliente.sexo == 'masculino'}">
					<option value="masculino">Masculino</option>
					<option value="feminino">Feminino</option>
				</c:when>
			</c:choose>
			</select>
			<p />
			
			Nascimento:<br />
			<input type="date" name="dtnasc" 
				value="<fmt:formatDate value='${cliente.nascimento}' pattern="yyyy-MM-dd" />" 
				title="Informe a Data de Nascimento" required="required" />
			<p />
			
		</fieldset>
		
		<fieldset>
			<legend>Informe o endereço do cliente</legend>
			
			Id Endereço:<br />
			<input type="text" name="idend" value="${cliente.endereco.idEndereco}" readonly="readonly" />
			<p />
			
			Rua:<br />
			<input type="text" name="rua" value="${cliente.endereco.rua}" required="required" />
			<p />
			
			Bairro:<br />
			<input type="text" name="bairro" value="${cliente.endereco.bairro}" required="required" />
			<p />
			
			Cidade:<br />
			<input type="text" name="cidade" value="${cliente.endereco.cidade}" required="required" />
			<p />
			
		</fieldset>
		<input type="submit" value="Alterar" />
	</form>
	

</body>
</html>