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
				<th>altura</th>
				<th>antebraco</th>
				<th>biceps</th>
				<th>cintura</th>
				<th>coxa</th>
				<th>peso</th>
				<th>gluteo</th>
				<th>mtorax</th>
				<th>panturrilha</th>
				<th>data da condicao</th>
				<th></th>
			</tr>
			<c:forEach items="${bodyConditions}" var="bodyCondition">
				<tr id="bodyConditions_${bodyCondition.id}">
					<td>${bodyCondition.id}</td>
					<td>${bodyCondition.altura }</td>
					<td>${bodyCondition.antebraco }</td>
					<td>${bodyCondition.biceps}</td>
					<td>${bodyCondition.cintura }</td>
					<td>${bodyCondition.coxa }</td>
					<td>${bodyCondition.peso}</td>
					<td>${bodyCondition.gluteo }</td>
					<td>${bodyCondition.mtorax }</td>
					<td>${bodyCondition.panturilha }</td>
					<td>${bodyCondition.datadacondicao }</td>
					<th></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>