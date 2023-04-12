<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
					    <% if(request.getParameter("ConnexionSubmit") != null) { 
				            if(request.getParameter("identifiant") == null || request.getParameter("identifiant").trim().isEmpty()) { %>
				                <span style="color:red">Veuillez remplir ce champ avec un identifiant valide</span>
				        <% } } %>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="motdepasse" class="col-sm-2 col-form-label">Mot de passe<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</label>
				<div class="col-sm-10">
					<input type="password" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" class="form-control" id="motdepasse" name="motdepasse">
					  <% if(request.getParameter("ConnexionSubmit") != null) { 
				            if(request.getParameter("motdepasse") == null || request.getParameter("motdepasse").trim().isEmpty()) { %>
				                <span style="color:red">Veuillez remplir ce champ avec un mot de passe valide</span>
				        <% } } %>
				</div>
			</div>
			<% if(request.getParameter("ConnexionSubmit") != null) { 
				if (request.getAttribute("error") != null) {%> 
				<%= request.getAttribute("error")  %>
			<%} }%>

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
					<input type="submit" id="ConnexionSubmit" name="ConnexionSubmit" class="btn btn-secondary" value="Connexion">
				</div>
			</div>

		</form>
	</div>
</div>
<div class="text-center">
	<a href=""><button type="button" class="btn btn-secondary" style="margin-left:50px;">Mot de passe oublié</button></a>
	<a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
</div>
</body>
</html>