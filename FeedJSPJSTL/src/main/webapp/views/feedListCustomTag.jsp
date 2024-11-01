<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://domain/tags" prefix="custom"%>

<html>
<head>
<title>Feed List</title>
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
	<h1>Feed List From Custom Tag</h1>

	<custom:feedTag feeds="${feeds}" />

</body>
</html>
