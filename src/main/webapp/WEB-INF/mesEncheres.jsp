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
<title>Mes Enchères</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-center"><h1>Mes enchères</h1></div>
</body>
</html>