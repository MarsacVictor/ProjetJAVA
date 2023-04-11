<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<form method="post" class="" action="${pageContext.request.contextPath}/servletConn" style=" width: 800px; display: block; margin: 0 auto; margin-top: 150px; ">

				<div class="form-group row">
					<label for="Identifiant" class="col-sm-2 col-form-label">Identifiant<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="identifiant" name="identifiant">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="motdepasse" class="col-sm-2 col-form-label">Mot de passe<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</label>
					<div class="col-sm-10">
						<input type="password" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" class="form-control" id="motdepasse" name="motdepasse">
					</div>
				</div>


				<div class="form-group row">
					<div class="col-sm-10 offset-sm-2">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="seSouvenir">
							<label class="form-check-label" for="seSouvenir">Se souvenir de moi</label>
						</div>
					</div>
				</div>
				<div><h6><span style="color: red;font-size:20px;position: relative;top: -12px;">*</span> Champs obligatoire</h6></div>
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-secondary">Connexion</button>
					</div>
				</div>

			</form>
		</div>
	</div>
	<% if (request.getAttribute("error") != null) {%> 
				<%= request.getAttribute("error")  %>
	<%} %>
	<div class="text-center">
		<a href=""><button type="button" class="btn btn-secondary" style="margin-left:50px;">Mot de passe oublié</button></a>
		<a href="${pageContext.request.contextPath}/servletInscription"><button type="button" class="btn btn-secondary">Créer compte</button></a>
	</div>
</body>
</html>