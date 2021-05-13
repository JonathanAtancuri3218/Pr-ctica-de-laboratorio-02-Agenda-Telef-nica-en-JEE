<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  style="background-color:powderblue;" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="background-color: powderblue;">

	${requestScope.variablePeticion} ${pageScope.variablePagina}

	<c:set var="p3" value="${resultado}" />

	<h1
		style="color: blue; font-family: verdana; text-align: center; border: 1px solid black;">Telefonos</h1>
	<form action="/AgendaTelefonica/BuscarListarPorCorreo"
		style="border: 1px solid black; padding: 30px;">
		<h3 style="color: blue; font-family: verdana; text-align: center;">Listar
			telefonos asociados</h3>
		<input type="hidden" name="buscar"
			value="${sessionScope.variableSession}">
		<hr />
		<br /> <input
			style="text-decoration: none; padding: 10px; font-weight: 600; font-size: 20px; color: #ffffff; background-color: #1883ba; border-radius: 6px; border: 2px solid #0016b0; text-align: center; align-items: center; justify-content: center; margin: auto; display: block;"
			type="submit" value="Enviar">
		<table class="table table-striped" width="50%" border="1"
			align="center">
			<tr>
				<th scope="col">Id
				</td>
				<th scope="col">Numero
				</td>
				<th scope="col">Tipo
				</td>
				<th scope="col">Operadora
				</td>
				<th scope="col">Eliminar
				</td>
				<th scope="col">Modificar
				</td>
			</tr>
		</table>
		<c:forEach items="${resultado}" var="res">
			<table width="50%" border="1" align="center">
				<tr>
					<td>${res.getCodigo()}</td>
					<td>${res.getNumero()}</td>
					<td>${res.getTipo()}</td>
					<td>${res.getOperadora()}</td>
					<td><p>
							<a
								href="http://localhost:8080/AgendaTelefonica/JSPs/eliminar.jsp?codigo=${res.getCodigo()}">Eliminar
								Telefono</a>
						<p></td>
					<td><p>
							<a
								href="http://localhost:8080/AgendaTelefonica/JSPs/modificar.jsp?${sessionScope.variableSession}&codigo=${res.getCodigo()}">Modificar
								Telefono</a>
						<p></td>

				</tr>
			</table>

		</c:forEach>
	</form>

	<form action="/AgendaTelefonica/BuscarListarPorCorreo"
		style="border: 1px solid black; padding: 30px;">
		<h3 style="color: blue; font-family: verdana; text-align: center;">Opciones:</h3>
		<p>
			<a
				href=http://localhost:8080/AgendaTelefonica/JSPs/registrar.jsp?${sessionScope.variableSession}>Registrar
				telefono</a>
		<p>
	</form>
</body>
</html>