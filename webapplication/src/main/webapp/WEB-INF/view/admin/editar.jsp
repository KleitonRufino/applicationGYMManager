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
		<form class="form-horizontal" style="width: 500px;" action="alterarCliente" method="post">
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="nome"> Nome</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nome"
						placeholder="Nome" value="${cliente.nome }" name="nome">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="cpf"> Cpf</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cpf" placeholder="Cpf"
						value="${cliente.cpf }" name="cpf">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="telefone">
					telefone</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="telefone"
						placeholder="Telefone" value="${cliente.telefone }" name="telefone">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="nome"> Nascimento</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nascimento"
						placeholder="Data Nascimento" value="${cliente.dataNascimento }" name="dataNascimento">
				</div>
			</div>
			<input type="hidden" name="dataVencimento" value="${cliente.dataVencimento }">
			<input type="hidden" name="ativo" value="${cliente.ativo }">
			<input type="hidden" name="id" value="${cliente.id }">
			<button type="submit" class="btn btn-primary" >Salvar</button>
		</form>
	</div>


</body>
</html>