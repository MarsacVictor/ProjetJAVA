<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Déconnexion</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center">
		<h1>Déconnexion</h1>
		<br>
		<h6>Confirmer votre déconnexion</h6>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-6"><a href="${pageContext.request.contextPath}/deconnexion"><button type="button" class="btn btn-secondary">Déconnexion</button></a></div>
			<div class="col-lg-6"><a href=""><button type="button" class="btn btn-secondary">Annuler</button></a></div>
		</div>
	</div>
</body>
</html>