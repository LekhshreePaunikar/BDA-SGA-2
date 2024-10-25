<html>
<head>
    <title>Update Author</title>
</head>
<body>
<h2>Update Author</h2>
<form action="/authors/update/${author.id}" method="post">
    Name: <input type="text" name="name" value="${author.name}" required /><br/><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
