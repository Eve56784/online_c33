<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<h1>Add book</h1>
<form action="${pageContext.request.contextPath}/bookshop/add" method="post">
    <input type="text" name="title" required/>
    <input type="text" name="author" required/>
    <input type="number" name="price" step="0.01" required/>
    <input type="submit" value="Add"/>
</form>
<a href="${pageContext.request.contextPath}/bookshop">Cancel</a>