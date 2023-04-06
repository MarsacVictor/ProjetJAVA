<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			<a class="navbar-brand mt-2 mt-lg-0" href="${pageContext.request.contextPath}/DirectionAccueil"> <img
				src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
				height="15" alt="Logo ENI-Enchères"/>
			</a>
	    </div>
	
	    <div class="d-flex align-items-center">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionEncheres">Enchères</a></li>
			</ul>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionVendreUnArticle">Vendre un article</a></li>
			</ul>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionMonProfil">Mon profil</a></li>
			</ul>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DirectionDeconnexion">Déconnexion</a></li>
			</ul>
		</div>
	</div>
</nav>

</body>
</html>