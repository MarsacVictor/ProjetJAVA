<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<form method="get" class="form-example" action="servletInscription">
  <div class="form-example">
    <label for="name">Entrez votre pseudo : </label>
    <input type="text" name="pseudo" id="pseudo" required>
  </div>
  <div class="form-example">
    <label for="email">Entrez votre email: </label>
    <input type="email" name="email" id="email" required>
  </div>
  <div class="form-example">
    <label for="email">Entrez votre mot de passe: </label>
    <input type="password" name="mdp" id="mdp" required>
  </div>
  <div class="form-example">
    <input type="submit" value="Valider">
  </div>
</form>
</body>
</html>