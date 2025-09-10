<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Producer</title></head>
<body>
<h2>New Producer for DB</h2>
<form action="addProducer" method="post">
    ID: <input type="text" name="id" required><br>
    Name: <input type="text" name="name" required><br>
    Country: <input type="text" name="country" required><br>
    Web: <input type="text" name="website"><br>
    <button type="submit">Add</button>
</form>
<a href="producers">Back</a>
</body>
</html>