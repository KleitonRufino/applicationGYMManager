<!DOCTYPE html>
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
		<form class="form-horizontal" style="width: 500px;" action="/webapplication/administracao/adicionaCliente" method="post">
			
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="email"> Email</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="email"
						placeholder="Email" name="email">
				</div>
			</div>
			
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="nome"> Nome</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nome"
						placeholder="Nome" name="nome">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="cpf"> Cpf</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cpf" placeholder="Cpf" name = "cpf">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="telefone">
					telefone</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="telefone"
						placeholder="Telefone" name ="telefone">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="nome"> Nascimento</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nascimento"
						placeholder="Data Nascimento" name="dataNascimento">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>


</body>
</html>