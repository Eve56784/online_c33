<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Page</title>
</head>
<body>
<h2>Input your first and last name:</h2>
<form action="/jspjstl_war/request" method="post">
    <p>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name"/>
    </p>
    <p>
        <label for="lastName">Last name:</label>
        <input type="text" name="lastName" id="lastName"/>
    </p>
    <p>
        <label for="message">Message:</label>
        <textarea name="message" id="message"></textarea>
    </p>
    <p>
        <input type="submit" value="Send"/>
    </p>
</form>
</body>
</html>
