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

.navbar {
	margin-bottom: 20px;
}
</style>

<jsp:include page="../modulos/headerAdmin.jsp" />
<title>Insert title here</title>
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
		<form
			action="/webapplication/administracao/cadastraCondicaFisicaCliente"
			method="post">
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="altura"> Altura</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="altura"
						placeholder="Altura" name="altura">
				</div>
			</div>
			<br /> <br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="antebraco">
					Antebraco</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="antebraco"
						placeholder="Antebraco" name="antebraco">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="biceps"> Biceps</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="biceps"
						placeholder="Biceps" name="biceps">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="cintura"> Cintura</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cintura"
						placeholder="Cintura" name="cintura">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="coxa"> coxa</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="coxa"
						placeholder="Coxa" name="coxa">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="dataCondicao">
					data Condicao</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="dataCondicao"
						placeholder="Data Condicao" name="dataCondicao">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="gluteo"> gluteo</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="gluteo"
						placeholder="Gluteo" name="gluteo">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="torax"> Torax</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="torax"
						placeholder="Torax" name="Mtorax">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="panturrilha">
					Panturrilha</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="panturrilha"
						placeholder="Panturrilha" name="panturilha">
				</div>
			</div>
			<br />
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="peso"> Peso</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="peso"
						placeholder="Peso" name="peso">
				</div>
			</div>
			<br /> <input type="hidden" name="idCliente" value="${cliente.id }" />
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>

	</div>


</body>
</html>