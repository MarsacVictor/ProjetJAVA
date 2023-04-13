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
	<title>Accueil</title>
	 <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #FFF">
	<div class="text-center" style="color: #FFF"><h1>Liste des enchères</h1></div>
	
	<br>
	<div class="container">
		<div class="row">	
			<h3 style="color: #F2913D">Filtres:</h3>
			<br>
			<div>
				<form>
					<div class="form-row">
						<input style="margin-left: 110px; width: 250px; border: 3px solid #F2913D; border-radius: 999px;" type="text" class="form-control" placeholder="Le nom de l'article contient">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<br>
	
	<div class="container">
		<div class="row">
			<div>
				<h3 style="color: #F2913D">Catégorie : </h3>
			</div>		
			<form style="margin-left: 50px;">
				<div class="form-row">
					<div class="col-auto my-1">
					      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" style="border: 3px solid #f2913d">
					        <option selected>Choisir</option>
					        <%for(Categorie c : (List<Categorie>)request.getAttribute("listCategorie")) {%>
					        	<option value=<%= c.getLibelle() %>><%= c.getLibelle() %></option>
					        <%} %>
					      </select>
					</div>
				</div>
			</form>
			<button type="submit" class="btn btn-light" style="margin-left: 50px;">Rechercher</button>
		</div>
	</div>
	 <%if (session.getAttribute("identifiant") != null) {%> 
	 <div class="container">
	 	<div class="row">
			<div class="col-3">
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="AchatCheck">
				  <label class="form-check-label" for="AchatCheck">Achat</label>
				</div>
					<!-- Si actif afficher les radio -->
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="EnchereOuverteCheck" value="option1" checked>
					  <label class="form-check-label" for="EnchereOuverteCheck">enchères ouvertes</label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="MesEncheresCheck" value="option1" checked>
					  <label class="form-check-label" for="MesEncheresCheck">mes enchères en cours</label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="MesEncheresRemporteCheck" value="option1" checked>
					  <label class="form-check-label" for="MesEncheresRemporteCheck">mes enchères remportées</label>
					</div>
			</div>
			<div class="col-3">
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="MesVentesCheck">
				  <label class="form-check-label" for="MesVentesCheck">Mes ventes</label>
				</div>
					<!-- Si actif afficher les radio -->
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="MesVentesEncoursCheck" value="option1" checked>
					  <label class="form-check-label" for="MesVentesEncoursCheck">mes ventes en cours</label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="MesVentesNonDebuteCheck" value="option1" checked>
					  <label class="form-check-label" for="MesVentesNonDebuteCheck">ventes non débutées</label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="VentesTermineCheck" value="option1" checked>
					  <label class="form-check-label" for="VentesTermineCheck">ventes terminées</label>
					</div>
			</div>
	 	</div>
	 </div>
    <%}%>
	<br>
	
	<!-- Carte -->
	<div class="container">
		<div class="row">
			
			<% for (ArticleVendu article : (List<ArticleVendu>) request.getAttribute("articles")) { %>
			<div class="col-lg-4" style="margin-bottom:20px;">
				<div class="card float-right">
					<div class="row">
						<div class="col-sm-6">
				         	<img style="height:180px;" src="https://img.toolstud.io/240x240/3b5998/fff&text=+180x180+" alt="">
				        </div>
				        <div class="col-sm-6">
				        	<h5 class="card-title">
								<%if (session.getAttribute("identifiant") != null) {%><a href="DirectionDetailEncheres?<%= article.getNoArticle()%>"><%}%>
									<%= article.getNomArticle() %>
								<%if (session.getAttribute("identifiant") != null) {%></a> <%}%>
							
							</h5>
				        	<p>Prix: <%= article.getPrixVente() %></p>
				        	<p>Fin de l'enchère: <%= article.getDateFinEncheres() %></p>
				        	<p>Vendeur:<%if (session.getAttribute("identifiant") != null) {%><a href="DirectionProfilUtilisateur"> <%}%>
											<%= article.getUtilisateur().getPseudo() %>
										<%if (session.getAttribute("identifiant") != null) {%></a> <%}%>
							</p>
						</div>
					</div>
				</div>	
			</div>
			<%} %>

		</div>
	</div>
	
</body>
</html>