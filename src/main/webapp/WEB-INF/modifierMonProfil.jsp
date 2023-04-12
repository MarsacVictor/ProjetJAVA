<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="navbar_connecte.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier profil</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center">
		<h1>Mon profil</h1>
	</div>
	<br>
	<div class="container">
		<div class="row">
		<form method="post" class="" action="servletModificationProfil">	
			<div class="form-row" style="width: 1200px;">
			
				<div class="form-group col-md-6">
					<label for="Pseudo"><h3>Pseudo:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^(?!.*\.\.)(?!.*\.$)[^\W][\w.]{0,29}$" class="form-control" aria-label="Pseudo" id="pseudo" name="pseudo" value=<%= request.getAttribute("pseudo")%> readonly>
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Prenom"><h3>Prenom:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^[^0-9]{2,}$" class="form-control" value="<%= request.getAttribute("prenom")%>" aria-label="Prenom" id="prenom" name="prenom">
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="Email"><h3>Email:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" class="form-control" value="<%= request.getAttribute("email")%>" aria-label="Email" id="email" name="email" readonly>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Telephone"><h3>Telephone:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^0[1-9]([-. ]?[0-9]{2}){4}$" class="form-control" value="<%= request.getAttribute("telephone")%>" aria-label="Telephone" id="telephone" name="telephone">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Rue"><h3>Rue:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^[1-9][0-9]{0,2}(bis|ter)? [a-zA-ZÀ-ÿ\s.'-]{2,30}$" class="form-control" value="<%= request.getAttribute("rue")%>" aria-label="Rue" id="rue" name="rue">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Code_Postal"><h3>Code Postal:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^(F-)?((2[A|B])|[0-9]{2})[0-9]{3}$" class="form-control" value="<%= request.getAttribute("code_postal")%>" aria-label="codepostal" id="code_postal" name="code_postal">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Ville"><h3>Ville:</h3></label>
					<div class="col-sm-10">
						<input type="text" pattern="^[a-zA-ZÀ-ÿ]+(?:[\s-][a-zA-ZÀ-ÿ]+)*$" class="form-control" value="<%= request.getAttribute("ville")%>" aria-label="Ville" id="ville" name="ville">
					</div>
				</div>

					<div class="form-group col-md-6">
						<label for="Confirmation"><h3>Crédit:</h3></label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext"
								placeholder="<%=request.getAttribute("credit")%>" name="credit" id="credit">
						</div>
					</div>

				<div class="form-group col-md-6">
					<label for="MotDePasse"><h3>Mot de passe:</h3></label>
					<div class="col-sm-10">
						<input type="password" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" class="form-control" placeholder="Mot de passe" aria-label="MotDePasse" required id="mot_de_passe" name="mot_de_passe" required>
					</div>
				</div>
				
				<div class="form-group col-md-6"></div>
				
				<div class="form-group col-md-6">
					<label for="News_MotDePasse"><h3>Nouveau mot de passe:</h3></label>
					<div class="col-sm-10">
						<input type="password" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" class="form-control" placeholder="Mot de passe" aria-label="News_MotDePasse" id="new_mot_de_passe" name="new_mot_de_passe" required>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="Confirmation"><h3>Confirmation:</h3></label>
					<div class="col-sm-10">
						<input type="password" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" class="form-control" placeholder="Confirmation" aria-label="Confirmation" id="confirmation" name="confirmation" required>
					</div>
				</div>
				
			</div>
				<div class="text-center">
					<button type="submit" class="btn btn-secondary">Enregistrer</button>
					<a href="${pageContext.request.contextPath}/RedirectionSuppression"><button type="button" class="btn btn-secondary">Supprimer mon compte</button></a>
				</div>
			</form>
			<% if(request.getParameter("ConnexionSubmit") != null) { 
				if (request.getAttribute("error2") != null) {%> 
				<%= request.getAttribute("error2")  %>
			<%} }%>
		</div>
	</div>
</body>
</html>