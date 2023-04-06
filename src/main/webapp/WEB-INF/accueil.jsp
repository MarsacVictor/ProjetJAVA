<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if (session.getAttribute("identifiant") != null) {%> 
    	<%@ include file="navbar_connecte.jsp" %>
    <%} else {%>
    		<%@ include file="navbar.jsp" %>	
    	<%} %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
					        <option value="1">Toutes</option>
					        <option value="2">Informatique</option>
					        <option value="3">Ameublement</option>
					        <option value="4">Vêtement</option>
					        <option value="5">Sport&Loisirs</option>
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
			<div class="col-lg-4">
				<div class="card float-right">
					<div class="row">
						<div class="col-sm-5">
				         	<img class="d-block w-100" src="https://picsum.photos/150?image=641" alt="">
				        </div>
				        <div class="col-sm-7">
				        	<h5 class="card-title">Titre carte</h5>
				        	<p>Prix: X</p>
				        	<p>Fin de l'enchère: X</p>
				        	<p>Vendeur: X</p>
				        </div>
					</div>
				</div>	
			</div>
			<div class="col-lg-4">
				<div class="card float-right">
					<div class="row">
						<div class="col-sm-5">
				         	<img class="d-block w-100" src="https://picsum.photos/150?image=641" alt="">
				        </div>
				        <div class="col-sm-7">
				        	<h5 class="card-title">Titre carte</h5>
				        	<p>Prix: X</p>
				        	<p>Fin de l'enchère: X</p>
				        	<p>Vendeur: X</p>
				        </div>
					</div>
				</div>	
			</div>
			<div class="col-lg-4">
				<div class="card float-right">
					<div class="row">
						<div class="col-sm-5">
				         	<img class="d-block w-100" src="https://picsum.photos/150?image=641" alt="">
				        </div>
				        <div class="col-sm-7">
				        	<h5 class="card-title">Titre carte</h5>
				        	<p>Prix: X</p>
				        	<p>Fin de l'enchère: X</p>
				        	<p>Vendeur: X</p>
				        </div>
					</div>
				</div>	
			</div>
		</div>
	</div>
	
</body>
</html>