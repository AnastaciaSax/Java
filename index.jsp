<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Producers</title></head>
<body>
<h2>Producer List</h2>
<a href="addProducer">New</a>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Country</th><th>Web</th><th>Actions</th>
    </tr>
    <c:forEach var="p" items="${producers}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.country}</td>
            <td>${p.website}</td>
            <td>
                <a href="updateProducer?id=${p.id}">Update</a>
                <form action="deleteProducer" method="post" style="display:inline">
                    <input type="hidden" name="id" value="${p.id}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
