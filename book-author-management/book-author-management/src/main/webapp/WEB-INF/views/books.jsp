<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books List</h2>
<a href="/books/new">Add New Book</a>
<form action="/books/author" method="get">
    <input type="text" name="name" placeholder="Author Name" />
    <input type="submit" value="Search" />
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${listBooks}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author.name}</td>
            <td>
                <a href="/books/edit/${book.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
