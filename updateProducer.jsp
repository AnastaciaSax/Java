<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Update Producer</title></head>
<body>
<h2>Update Producer info</h2>
<form action="updateProducer" method="post">
    <input type="hidden" name="id" value="${producerId}">
    Name: <input type="text" name="name" required><br>
    Country: <input type="text" name="country" required><br>
    Web: <input type="text" name="website"><br>
    <button type="submit">Change</button>
</form>
<a href="producers">Back</a>
</body>
</html>