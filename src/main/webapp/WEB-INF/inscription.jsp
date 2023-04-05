<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="navbar_connecte.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center">
		<h1>Mon profil</h1>
	</div>
	<br>
	<div class="container">
		<div class="row">
		<form method="get" class="" action="servletInscription">	
			<div class="form-row" style="width: 1200px;">
			
				<div class="form-group col-md-6">
					<label for="Pseudo"><h3>Pseudo:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Pseudo" aria-label="Pseudo">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Nom"><h3>Nom:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Nom" aria-label="Nom">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Prenom"><h3>Prenom:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Prenom" aria-label="Prenom ">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Email"><h3>Email:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Email" aria-label="Email">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Telephone"><h3>Telephone:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Telephone" aria-label="Telephone">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Rue"><h3>Rue:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Rue" aria-label="Rue">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Code_Postal"><h3>Code Postal:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Code postal" aria-label="codepostal">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Ville"><h3>Ville:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Ville" aria-label="Ville">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="MotDePasse"><h3>Mot de passe:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Mot de passe" aria-label="MotDePasse">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Confirmation"><h3>Confirmation:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Confirmation" aria-label="Confirmation">
					</div>
				</div>
				
			</div>
				<div class="text-center">
					<button type="submit" class="btn btn-secondary">Créer</button>
					<button type="submit" class="btn btn-secondary">Annuler</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>