<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<h2>Update Book</h2>
<form action="/books/update/${book.id}" method="post">
    Title: <input type="text" name="title" value="${book.title}" required /><br/><br/>
    Author:
    <select name="author.id">
        <c:forEach var="author" items="${listAuthors}">
            <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>${author.name}</option>
        </c:forEach>
    </select><br/><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
