<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil Utilisateur</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
	.row {
    padding: 30px;
    color: black;
    border-radius: 35px;
    box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -webkit-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -moz-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
	}
	.col-lg-4 {
	    text-align: initial;
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
	    text-decoration:none;
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
	    width: 115px;
	}
</style>
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