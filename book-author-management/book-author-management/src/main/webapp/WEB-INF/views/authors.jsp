<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<h2>Authors List</h2>
<a href="/authors/new">Add New Author</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="author" items="${listAuthors}">
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td>
                <a href="/authors/edit/${author.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
