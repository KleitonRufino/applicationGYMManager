<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="headerMain">
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">GYMManager</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="true">Notificacao
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/webapplication/cliente/listarnotifications">Minhas
										Notificacoes</a></li>
							</ul></li>
					</ul>

					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="true">Codicao
								Fisica <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/webapplication/cliente/listarBodyCondition">Minhas
										CF</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="true">Nutrição <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/webapplication/cliente/listarHistoricoDieta">Historico Dieta </a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/webapplication/sair">Sair</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</div>
</header>