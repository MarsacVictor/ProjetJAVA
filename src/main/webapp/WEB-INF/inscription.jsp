<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier profil</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center">
		<h1>Mon profil</h1>
	</div>
	<br>
	<div class="container">
		<div class="row">
		<form method="get" class="form-example" action="servletInscription">
			<div class="col-lg-6">
				<h3>Pseudo: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Pseudo" aria-label="Pseudo">
				</div>
			</div>
			<div class="col-lg-6">
				<h3>Nom: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Nom" aria-label="Nom">
				</div>
			</div>
			
			<div class="col-lg-6">
				<h3>Prenom: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Prenom" aria-label="Prenom">
				</div>
			</div>
			<div class="col-lg-6">
				<h3>Email: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Email" aria-label="Email">
				</div>
			</div>
			
			<div class="col-lg-6">
				<h3>Telephone: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Telephone" aria-label="Telephone">
				</div>
			</div>
			<div class="col-lg-6">
				<h3>Rue</h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Rue" aria-label="Rue">
				</div>
			</div>
			
			<div class="col-lg-6">
				<h3>Code postal</h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Code postal" aria-label="Code_Postal">
				</div>
			</div>
			<div class="col-lg-6">
				<h3>Ville</h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Ville" aria-label="Ville">
				</div>
			</div>
			
			<div class="col-lg-6">
				<h3>Mot de passe: </h3>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Mot de passe" aria-label="motdepasse">
				</div>
			</div>
			<div class="col-lg-6">
				Confirmation: 
			</div>
			<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Confirmation" aria-label="Confirmation">
			</div>
		</form>
		</div>
	</div>
	<div class="text-center">
		<button type="submit" class="btn btn-secondary">Créer</button>
		<button type="submit" class="btn btn-secondary">Annuler</button>
	</div>
</body>
</html>