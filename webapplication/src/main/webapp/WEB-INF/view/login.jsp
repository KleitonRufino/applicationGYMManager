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

<title>Login</title>
</head>
<body>
	<div class="container" style="width: 300px;">
		<form class="form-signin" action="efetuaLogin" method="post">
			<h2 class="form-signin-heading">Entre com seus dados</h2>
			<label for="inputEmail" class="sr-only">Email</label> <input
				name="email" type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required="required"
				autofocus="autofocus"><br /> <label for="inputPassword"
				class="sr-only">Senha</label> <input name="senha" type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				required="required"><br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>