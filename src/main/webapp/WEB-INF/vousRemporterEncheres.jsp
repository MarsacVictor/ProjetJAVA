<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%if (session.getAttribute("identifiant") != null) {%> 
    	<%@ include file="navbar_connecte.jsp" %>
    <%} else {%>
    		<%@ include file="navbar.jsp" %>	
    	<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Encheres remporté</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center"><h1>Vous avez remporté la vente</h1></div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<!-- IMAGE -->
				<div>
					<img src="https://dummyimage.com/300.png/09f/fff" width="300" height="300" alt="Photo_Produit">
				</div>
			</div>
			<div class="col-lg-6">
				<div><h3>Titre</h3></div>
				<div><h3>Description: </h3></div>
				<div><h3>Meilleure offre: </h3></div>
				<div><h3>Mise à prix: </h3></div>
				<div><h3>Retrait: </h3></div>
				<div><h3>Vendeur: </h3></div>
				<div><h3>Tel: </h3></div>
			</div>
			<div class="col-lg-2">
			
			</div>
			<div style="display:flex; margin: 0 auto;justify-content: center;"><a href="${pageContext.request.contextPath}/retourAccueil"><button type="submit" class="btn btn-secondary" style="margin-right:20px;">Back</button></a></div>
		</div>
	</div>
</body>
</html>