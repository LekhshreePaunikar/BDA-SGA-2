<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<h2>Add New Book</h2>
<form action="/books/save" method="post">
    Title: <input type="text" name="title" required /><br/><br/>
    Author:
    <select name="author.id">
        <c:forEach var="author" items="${listAuthors}">
            <option value="${author.id}">${author.name}</option>
        </c:forEach>
    </select><br/><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
