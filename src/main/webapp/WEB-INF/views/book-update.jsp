<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books update</title>
</head>
<body>
<h1>Book update</h1>
<form action="${pageContext.request.contextPath}/bookshop/update/${book.id}" method="post">
    <input type="text" name="title" value="${book.title}" required/>
    <input type="text" name="author" value="${book.author}" required/>
    <input type="number" name="price" value="${book.price}" required/>
    <input type="submit" value="Update"/>
</form>
<a href="${pageContext.request.contextPath}/bookshop">Cancel</a>