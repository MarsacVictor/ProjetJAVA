<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Vente</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="text-center"><h1>Modifier vente</h1></div>

	<form method="post" class="" action="servletNouvelleVente">
		<div class="form-row">
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="Article"><h3>Article:</h3></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="Article"
						aria-label="Article" required>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="Description"><h3>Description:</h3></label>
				<div class="col-sm-10">
					<textarea class="form-control" id="Description" placeholder="Description" required></textarea>
				</div>
			</div>
			<div class="form-group col-md-2"></div>

			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="categorie"><h3>Catégorie:</h3></label>
				<div class="col-sm-10">
					  <select class="custom-select my-1 mr-sm-2" id="categorie" required>
					    <option selected>Catégorie</option>
					        <option value="1">Toutes</option>
					        <option value="2">Informatique</option>
					        <option value="3">Ameublement</option>
					        <option value="4">Vêtement</option>
					        <option value="5">Sport&Loisirs</option>
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
						aria-label="MiseaPrix" required>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="MiseaPrix"><h3>Début de l'enchère:</h3></label>
				<div class="col-sm-10">
					<input type="date" id="DebutEnchereDate" name="trip-start" value="2023-01-01" min="2023-01-01" max="2025-12-31">
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<label for="MiseaPrix"><h3>Fin de l'enchère:</h3></label>
				<div class="col-sm-10">
					<input type="date" id="FinEnchereDate" name="trip-start" value="2023-01-01" min="2023-01-01" max="2025-12-31">
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6" style="border: 1px solid black">
				<label for="Retrait"><h3>Retrait:</h3></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="Rue" aria-label="Rue" required>
					<br>
					<input type="text" class="form-control" placeholder="Code Postal" aria-label="codePostal" required>
					<br>
					<input type="text" class="form-control" placeholder="Ville" aria-label="Ville" required>
					<br>
				</div>
			</div>
			<div class="form-group col-md-2"></div>
			
			<div class="form-group col-md-4"></div>
			<div class="form-group col-md-6">
				<button type="submit" class="btn btn-secondary">Enregistrer</button>
				<button type="submit" class="btn btn-secondary">Annuler</button>
				<button type="submit" class="btn btn-secondary">Annuler la vente</button>
			</div>
			<div class="form-group col-md-2"></div>
			
		</div>
	</form>

</body>
</html>