<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Actualizar Candidato</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Actualizar
						Candidato</h1> Candidato Management App </a>
			</div>
		</nav>
	</header>

	<hr>
	<div id="botones" class="container text-left">
		
		<a href="<%=request.getContextPath()%>/CandidatoController?action=index" class="btn btn-success">Ir al
			men�</a> 			
		<a href="<%=request.getContextPath()%>/vistaCandidato/registro.jsp"
					class="btn btn-success">Registrar nuevo Candidato</a>
		<a href="<%=request.getContextPath()%>/vistaCandidato/mostrar.jsp"
			class="btn btn-success">Listar Candidatos</a>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/CandidatoController?action=editar" method="post">
					<div class="form-group">
						<label for="validation01">Id</label> <input type="number"
							class="form-control" value='<c:out value="${candidato.id}"></c:out>'
							placeholder="Id" name="id" >
					</div>
					<div class="form-group">
						<label for="validation01">Documento</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.documento}"></c:out>'
							placeholder="Documento" name="documento">
					</div>
					<div class="form-group">
						<label for="validation01">Nombre</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.nombre}"></c:out>'
							placeholder="Nombre" name="nombre">
					</div>
					
					<div class="form-group">
						<label for="validation01">Apellido</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.apellido}"></c:out>'
							placeholder="Apellido" name="apellido">
					</div>
					<div class="form-group">
						<label for="validation01">Elecci�n</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.eleccion}"></c:out>'
							placeholder="Eleccion" name="eleccion">
					</div>
					<div class="form-group">
						<label for="validation01">N�mero</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.numero}"></c:out>'
							placeholder="N�mero" name="numero">
					</div>			
						<input type="submit" class="btn btn-success" value="Guardar"
							name="guardar">
					
				</form>
			</div>
		</div>
	</div>

	
    <style>
footer {
    padding: 5px;
    background-color: #38C953;
    margin-top:20px;
}

footer p,b{
    text-align: center;
    color: white;
}
.container{
	width:60%;

}

form {
	margin: auto;
	display: block;
	width: 90%;
	border-radius: 10px;
}

#botones{
	margin:15px;
}

form input {
	width: 90%;
}

form input[type=submit]{
	width:100%;
}

</style>
</body>
</html>