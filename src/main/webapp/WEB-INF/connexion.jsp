<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
	form {
	    background-color: #293040;
	    border-radius: 35px;
	    padding: 2em;
	    box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
	    -webkit-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
	    -moz-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
	}
	label.col-sm-2.col-form-label {
	    color: white;
	    font-size: 20px;
	}
	input#ConnexionSubmit {
	    display: flex;
	    margin: 0 auto;
	    background-color: #F2913D;
	    border-radius: 25px;
	    font-size: 20px;
	    border: 0px;
	    box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -webkit-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -moz-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	}
	button.btn.btn-secondary {
	    background-color: #F2913D;
	    border-radius: 25px;
	    font-size: 20px;
	    border: 0px;
	    box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -webkit-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -moz-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    margin-top: 25px;
	    margin-inline: 30px;
	}	
			button.btn.btn-secondary:hover {
	    background-color: #F2B84B;
	    border-radius: 25px;
	    font-size: 20px;
	    border: 0px;
	    box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -webkit-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    -moz-box-shadow: 4px 4px 25px -3px rgba(0,0,0,0.75);
	    margin-top: 25px;
	    margin-inline: 30px;
	    text-decoration:none;
	    cursor: pointer;
	}
</style>
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

			<div><h6 style="color:white;"><span style="color: red;font-size:15px;position: relative;top: -12px;">*</span> Champs requis</h6></div>
			<div class="form-group row">
				<div style="width:100%;">
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