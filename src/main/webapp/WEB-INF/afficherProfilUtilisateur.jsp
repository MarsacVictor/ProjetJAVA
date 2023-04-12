<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil Utilisateur</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="text-center" style="width: 500px;display: flex;margin: 0 auto; margin-top:150px;">
		<div class="row">
			<div class="col-lg-4"><h3>Pseudo: </h3></div>
			<div class="col-lg-8"><%= request.getAttribute("pseudo")%></div>
			
			<div class="col-lg-4"><h3>Nom: </h3></div>
			<div class="col-lg-8"><%= request.getAttribute("nom")%></div>
			
			<div class="col-lg-4"><h3>Prénom: </h3></div>
			<div class="col-lg-8"><%= request.getAttribute("prenom")%></div>
			
			<div class="col-lg-4"><h3 style=" width: 160px;">Code postal: </h3></div>
			<div class="col-lg-8"><%= request.getAttribute("code_postal")%></div>
			
			<div class="col-lg-4"><h3>Ville: </h3></div>
			<div class="col-lg-8"><%= request.getAttribute("ville")%></div>
		</div>
	</div>
	<div class="text-center" style="margin-top:50px;">
		<a href="${pageContext.request.contextPath}/retourAccueil"><button type="submit" class="btn btn-secondary">Annuler</button></a>
	</div>
</body>
</html>