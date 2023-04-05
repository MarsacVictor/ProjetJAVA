<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if (session.getAttribute("pseudo") != null) {%> 
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
<body style="background-color: #293040">
	<div class="text-center" style="color: #FFF"><h1>Liste des enchères</h1></div>
	
	<br>
	<p>Bienvenue, ${sessionScope.pseudo}!</p>
	<p>Bienvenue, ${sessionScope.email}!</p>
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