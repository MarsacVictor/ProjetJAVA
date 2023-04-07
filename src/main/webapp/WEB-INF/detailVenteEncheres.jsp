<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("identifiant") != null) {
%>
<%@ include file="navbar_connecte.jsp"%>
<%
} else {
%>
<%@ include file="navbar.jsp"%>
<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détails enchères</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center"><h1>Détail vente</h1></div><br><br>
	<div class="container">
		<div class=row>
			<div class="col-lg-4">
				<!-- IMAGE -->
				<div>
					<img src="https://dummyimage.com/300.png/09f/fff" width="300" height="300" alt="Photo_Produit">
				</div>
			</div>
			
			<div class="col-lg-6">
				<div><h3>TITRE</h3></div><br>
				<div><h3>Description:</h3><!-- Donnée --></div><br>
				<div><h3>Catégorie</h3></div><br>
				<div><h3>Meilleur offre</h3></div><br>
				<div><h3>Fin de l'enchère</h3></div><br>
				<div><h3>Retrait</h3></div><br>
				<div><h3>Vendeur</h3></div><br>
				
				<form method="post" class="" action="">
					<div><h3>Ma proposition</h3><input type="number" class="form-control" id="identifiant" name="identifiant"></div><br>
					<div style="display:flex; margin: 0 auto;justify-content: center;"><button type="submit" class="btn btn-secondary" style="margin-right:20px;">Enchérir</button>
						<a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
					</div>
					
				</form>
			</div>
			
			<div class="col-lg-2">
			
			</div>
		</div>
	</div>
</body>
</html>