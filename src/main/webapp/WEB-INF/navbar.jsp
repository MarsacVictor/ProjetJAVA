<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
	nav.navbar.navbar-expand-lg.navbar-light.bg-light {
	    background-color: white !important;
	    border-bottom: 2px solid grey;
	}
</style>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<a class="navbar-brand mt-2 mt-lg-0" href="${pageContext.request.contextPath}/DirectionAccueil">
			<img src="Image/logoENIEncheres.png" height="60" alt="Logo ENI-Enchères"/>
		</a>
    </div>

    <div class="d-flex align-items-center">
		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionInscription"><button type="button" class="btn btn-outline-primary">S'inscrire</button></a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionConnexion"><button type="button" class="btn btn-outline-primary">Se connecter</button></a></li>
		</ul>
	</div>
</nav>

</body>
</html>