<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Feed List - JSTL</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f9f9f9;
			padding: 20px;
		}
		
		h1 {
			color: #333;
		}
		
		h2 {
			color: #007BFF;
			margin-top: 20px;
		}
		
		p {
			font-size: 1.1em;
			color: #555;
		}
		
		small {
			display: block;
			margin-top: 10px;
			color: #777;
		}
	</style>
</head>
<body>
	<h1>Feed List From JSTL - Core</h1>
	<c:forEach var="feed" items="${feeds}">
		<h2>${feed.title}</h2>
		<p>${feed.description}</p>
		<small>${feed.date}</small>
	</c:forEach>
</body>
</html>
