<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	<div class="container" style=" display: flex; margin: 0 auto; width: 500px; justify-content: center; ">
		<div class="row">
			<a href="${pageContext.request.contextPath}/deconnexion"><button type="button" class="btn btn-secondary" style="margin-right: 20px;">Déconnexion</button></a>
			<a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
		</div>
	</div>
</body>
</html>