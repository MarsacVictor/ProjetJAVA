<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supprimer compte</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
	.Background {
    color: black;
    padding: 30px;
    border-radius: 35px;
    width: 550px;
    display: block;
    margin: 0 auto;
    margin-top: 200px;
       box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -webkit-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -moz-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
}
h6.text-center {
    font-size: 30px;
    margin-bottom: 50px;
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
	    margin-bottom:25px;
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
	    margin-bottom:25px;	
	}
</style>
<div class="Background">
	<div class="text-center">
		<h6>Confirmer votre suppression de compte</h6>
	</div>
	<div class="container" style=" display: flex; margin: 0 auto; width: 500px; justify-content: center; ">
		<div class="row">
			<a href="${pageContext.request.contextPath}/suppression"><button type="button" class="btn btn-secondary" style="margin-right: 20px;">Supprimer</button></a>
			<a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
		</div>
	</div>
</div>
</body>
</html>