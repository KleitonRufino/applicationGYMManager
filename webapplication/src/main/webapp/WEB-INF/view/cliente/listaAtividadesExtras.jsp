<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

.table {
	margin-bottom: 20px;
}
</style>

<jsp:include page="../modulos/headerCliente.jsp" />
<title>Lista Notificacao</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty info}">
			<div class="alert alert-info alert-dismissible" role="alert"
				style="height: 50px;">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<c:out value="${info}"></c:out>
			</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>#</th>
				<th>nome</th>
				<th>duracao</th>
				<th>dia atividade</th>
				<th>hora atividade</th>
				<th></th>
			</tr>
			<c:forEach items="${activities}" var="activitie">
				<tr id="activitie_${activitie.id}">
					<td>${activitie.id}</td>
					<td>${activitie.nome }</td>
					<td>${activitie.duracao }</td>
					<td>${activitie.diaatividade }</td>
					<td>${activitie.horaatividade }</td>
					<th></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>