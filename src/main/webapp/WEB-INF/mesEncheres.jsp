<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%if (session.getAttribute("identifiant") != null) {%> 
    	<%@ include file="navbar_connecte.jsp" %>
    <%} else {%>
    		<%@ include file="navbar.jsp" %>	
    	<%} %>
<%@ page import="java.util.List" %>
<%@ page import="Class.Categorie" %>
<%@ page import="Class.ArticleVendu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Enchères</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
		.ImageRemplacement {
    height: 180px;
    width: 180px;
    background-color: #F2913D;
    border-radius: 12px;
    border: 5px solid white;
}
		.card.float-right {
	    border: 3px solid #F2913D;
	    border-radius: 15px;
	}
	a {
	    color: #F2913D;
	}
	a:hover {
	    color: #F2B84B;
	}
</style>
	<div class="text-center"><h1>Mes enchères</h1></div>
	<%if (request.getAttribute("error") != null) {%> 
				<%= request.getAttribute("error")  %>
	<%} else {%>
			<div class="container" style="margin-top:35px;">
		<div class="row">
			
			<% for (ArticleVendu article : (List<ArticleVendu>) request.getAttribute("articles")) { %>
			<div class="col-lg-4" style="margin-bottom:20px;">
				<div class="card float-right">
					<div class="row">
						<div class="col-sm-6">
				         	<!-- <img style="height:180px;" src="https://img.toolstud.io/240x240/3b5998/fff&text=+180x180+" alt=""> -->
				         	<div class="ImageRemplacement"></div>
				        </div>
				        <div class="col-sm-6">
				        	<h5 class="card-title">
								<%if (session.getAttribute("identifiant") != null) {%><a href="DirectionDetailEncheres?<%= article.getNoArticle()%>"><%}%>
									<%= article.getNomArticle() %>
								<%if (session.getAttribute("identifiant") != null) {%></a> <%}%>
							
							</h5>
				        	<p>Prix: <%= article.getPrixVente() %></p>
				        	<p>Fin de l'enchère: <%= article.getDateFinEncheres() %></p>
				        	<p>Vendeur:<%if (session.getAttribute("identifiant") != null) {%><a href="DirectionProfilUtilisateur?<%= article.getUtilisateur().getNo_utilisateur()%>"> <%}%>
											<%= article.getUtilisateur().getPseudo() %>
										<%if (session.getAttribute("identifiant") != null) {%></a> <%}%>
							</p>
						</div>
					</div>
				</div>	
			</div>
			<%} %>
	<% } %>
</body>
</html>