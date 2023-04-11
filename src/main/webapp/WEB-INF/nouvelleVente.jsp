<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Class.Categorie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="text-center"><h1>Nouvelle vente</h1></div>

	<form method="post" class="" action="servletNouvelleArticle">
		<div class="form-row">
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="Article"><h3>Article:</h3></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="Article"
						aria-label="Article" id="article" name="article" required>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="Description"><h3>Description:</h3></label>
				<div class="col-sm-10">
					<textarea class="form-control" id="description" name="description" placeholder="Description" required></textarea>
				</div>
			</div>
			<div class="form-group col-md-2"></div>

			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="categorie"><h3>Catégorie:</h3></label>
				<div class="col-sm-10">
					  <select class="custom-select my-1 mr-sm-2" id="categorie" name="categorie" required>
					    <option selected>Catégorie</option>
					        <%for(Categorie c : (List<Categorie>)request.getAttribute("listCategorie")) {%>
					        	<option value=<%= c.getLibelle() %>><%= c.getLibelle() %></option>
					        <%} %>
					  </select>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="PhotoArticle"><h3>Photo de l'article:</h3></label>
				<div class="col-sm-10">
					<input type="file" class="form-control-file" id="PhotoArticle">
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="MiseaPrix"><h3>Mise à prix:</h3></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="Prix"
						aria-label="MiseaPrix" name="prix" id ="prix" required>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="MiseaPrix"><h3>Début de l'enchère:</h3></label>
				<div class="col-sm-10">
					<input type="date" id="dateStart" name="dateStart" value="2023-01-01" min="2023-01-01" max="2025-12-31">
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="MiseaPrix"><h3>Fin de l'enchère:</h3></label>
				<div class="col-sm-10">
					<input type="date" id="dateEnd" name="dateEnd" value="2023-01-01" min="2023-01-01" max="2025-12-31">
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6" style="border: 1px solid black">
				<label for="Retrait"><h3>Retrait:</h3></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="<%= request.getAttribute("rue")%>" name="rue" id="rue" aria-label="Rue" required>
					<br>
					<input type="text" class="form-control" placeholder="<%= request.getAttribute("code_postal")%>" name="code_postal" id="code_postal" aria-label="codePostal" required>
					<br>
					<input type="text" class="form-control" placeholder="<%= request.getAttribute("ville")%>" aria-label="Ville" name="ville" id="ville" required>
					<br>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<a href=""><button type="submit" class="btn btn-secondary">Enregistrer</button></a>
				<a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
			</div>
			<div class="form-group col-md-2"></div>
			
		</div>
	</form>

</body>
</html>