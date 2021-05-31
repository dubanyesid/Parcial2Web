<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Candidatos</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Administrar
			Candidatos</h1> Candidatos Management App </a>
			</div>
		</nav>
	</header>

	<div class="container">
		<hr>
		<div id="botones" class="container text-left">
			<a href="<%=request.getContextPath()%>/vistaCandidato/registro.jsp"
					class="btn btn-success">A�adir nuevo Candidato</a> 
			<a href="CandidatoController?action=mostrar" class="btn btn-success">Mostrar listado de Candidatos</a>
		</div>
	</div>

</body>
</html>