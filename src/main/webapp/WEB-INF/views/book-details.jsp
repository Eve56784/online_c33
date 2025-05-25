<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book details</title>
</head>
<body>
<h1>Book details</h1>
<p>Id: ${book.id}</p>
<p>Title: ${book.title}</p>
<p>Author: ${book.author}</p>
<p>Price: ${book.price}</p>
<a href="${pageContext.request.contextPath}/bookshop">Back</a>
</body>
</html>