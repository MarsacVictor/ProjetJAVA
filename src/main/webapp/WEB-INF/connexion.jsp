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
			<form method="post" class="" action="servletConnexion" style=" width: 500px; display: block; margin: 0 auto; margin-top: 150px; ">

				<div class="form-group row">
					<label for="Identifiant" class="col-sm-2 col-form-label">Identifiant</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="Identifiant">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="motdepasse" class="col-sm-2 col-form-label">Mot de passe</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id=""motdepasse"">
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
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-secondary">Connexionnn</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>