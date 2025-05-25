<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Available</title>
</head>
<body>
<h1>Books Available</h1>
<table border="1">
    <tr>
        <th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <form action="${pageContext.request.contextPath}/bookshop/delete/${book.id}" method="post">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/bookshop/${book.id}" method="get">
                    <input type="submit" value="View details"/>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/bookshop/update/${book.id}" method="get">
                    <input type="submit" value="Update"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add new book</h2>
<a href="${pageContext.request.contextPath}/bookshop/add">Add New Book</a>

</body>
</html>
