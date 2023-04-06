<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="navbar_connecte.jsp" %>
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
		<form method="post" class="" action="servletModificationProfil">	
			<div class="form-row" style="width: 1200px;">
			
				<div class="form-group col-md-6">
					<label for="Pseudo"><h3>Pseudo:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("pseudo")%>" aria-label="Pseudo">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Nom"><h3>Nom:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("nom")%>" aria-label="Nom">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Prenom"><h3>Prenom:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("prenom")%>" aria-label="Prenom ">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Email"><h3>Email:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("email")%>" aria-label="Email">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Telephone"><h3>Telephone:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("telephone")%>" aria-label="Telephone">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Rue"><h3>Rue:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("rue")%>" aria-label="Rue">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Code_Postal"><h3>Code Postal:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("code_postal")%>" aria-label="codepostal">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Ville"><h3>Ville:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="<%= request.getAttribute("ville")%>" aria-label="Ville">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="MotDePasse"><h3>Mot de passe:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Mot de passe" aria-label="MotDePasse" required>
					</div>
				</div>
				
				<div class="form-group col-md-6">
				</div>
				
				<div class="form-group col-md-6">
					<label for="News_MotDePasse"><h3>Nouveau mot de passe:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Mot de passe" aria-label="News_MotDePasse">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Confirmation"><h3>Confirmation:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Confirmation" aria-label="Confirmation">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Confirmation"><h3>Cr�dit:</h3></label>
					<div class="col-sm-10">
						<input type="text" readonly class="form-control-plaintext" placeholder="<%= request.getAttribute("credit")%>">
					</div>
				</div>
				
			</div>
				<div class="text-center">
					<button type="submit" class="btn btn-secondary">Enregistrer</button>
					<a href="${pageContext.request.contextPath}/retourAccueil"><button type="submit" class="btn btn-secondary">Supprimer mon compte</button></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>