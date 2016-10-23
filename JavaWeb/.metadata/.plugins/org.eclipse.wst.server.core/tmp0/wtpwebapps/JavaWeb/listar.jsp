<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Produtos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

	<div class="container">
	
		<div class="row">
			<div class="page-header"><h1>Listar Produtos</h1></div>
		</div>
		
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<td>Nome</td>
						<td>Valor</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="item" items="${lista }">
						<tr>
							<td>${item.nome}</td>
							<td>${item.valor}</td>
						</tr>					
					</c:forEach>
				</tbody>			
			</table>
		</div>
	
	</div>


</body>
</html>