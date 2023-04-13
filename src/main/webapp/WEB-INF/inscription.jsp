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
<title>Inscription</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
	.container {
	    color: black;
	    border-radius: 35px;
	    padding: 35px;
	        box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -webkit-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
    -moz-box-shadow: 10px 10px 45px -3px rgba(0,0,0,0.75);
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
	    margin-inline: -30px;
	    text-decoration:none;
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
	    margin-inline: -30px;
	    text-decoration:none;
	    cursor: pointer;
	}
</style>
	<div class="text-center">
		<h1>Inscription</h1>
	</div>
	<br>
	<div class="container">
		<div class="row">
		<form method="post" class="" action="${pageContext.request.contextPath}/servletCreer">	
			<div class="form-row" style="width: 1200px;">
			
				<div class="form-group col-md-6">
					<label for="pseudo"><h3>Pseudo<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^(?!.*\.\.)(?!.*\.$)[^\W][\w.]{0,29}$" placeholder="Pseudo" aria-label="pseudo" name="pseudo" id="pseudo" required>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="nom"><h3>Nom<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^[^0-9]{2,}$" placeholder="Nom" aria-label="nom" name="nom" id="nom" required>
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="prenom"><h3>Prenom<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^[^0-9]{2,}$" placeholder="Prenom" aria-label="prenom" name="prenom" id="prenom" required>
					</div>
				</div>
				
				<div class="form-group col-md-6">
					<label for="email"><h3>Email<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" placeholder="Email" aria-label="email" name="email" id="email" required>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="telephone"><h3>Telephone:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^0[1-9]([-. ]?[0-9]{2}){4}$" placeholder="Telephone" aria-label="telephone" name="telephone" id="telephone" >
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="rue"><h3>Rue<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^[1-9][0-9]{0,2}(bis|ter)? [a-zA-ZÀ-ÿ\s.'-]{2,30}$" placeholder="Rue" aria-label="rue" name="rue" id="rue">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="code_postal"><h3>Code Postal<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^(F-)?((2[A|B])|[0-9]{2})[0-9]{3}$" placeholder="Code postal" aria-label="code_postal" name="code_postal" id="code_postal">
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="ville"><h3>Ville<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" pattern="^[a-zA-ZÀ-ÿ]+(?:[\s-][a-zA-ZÀ-ÿ]+)*$" placeholder="Ville" aria-label="ville" name="ville" id="ville" required>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="mot_de_passe"><h3>Mot de passe<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" placeholder="Mot de passe" aria-label="mot_de_passe" name="mot_de_passe" id="mot_de_passe" required>
					</div>
				</div>
			
				<div class="form-group col-md-6">
					<label for="confirmation"><h3>Confirmation<span style="color: red;font-size:20px;position: relative;top: -12px;">*</span>:</h3></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[^\da-zA-Z]).{12,}$" placeholder="Confirmation" aria-label="Confirmation" name="confirmation" id="confirmation" required>
					</div>
				</div>
				<div><h6><span style="color: red;font-size:20px;position: relative;top: -12px;">*</span> Champs obligatoire</h6></div>
			</div>
				<div class="text-center">
					<button type="submit" class="btn btn-secondary" id="cr">Créer</button>
                    <a href="${pageContext.request.contextPath}/retourAccueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
				</div>
			</form>
			<% if (request.getAttribute("error") != null) {%> 
				<%= request.getAttribute("error")  %>
			<%} %>
			<% if (request.getAttribute("error2") != null) {%> 
				<%= request.getAttribute("error2")  %>
			<%} %>
		</div>
	</div>
</body>
</html>