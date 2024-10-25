<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add New Author</title>
</head>
<body>
<h2>Add New Author</h2>
<form:form action="/authors/save" modelAttribute="author" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save" />
                <a href="/authors">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
