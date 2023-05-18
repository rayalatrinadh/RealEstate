<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<!-- <div class = "container">
	<input class = "btn btn-success" type ="button" value = "view">
</div> -->
	<div class="container">
		<div align="center">
			<form:form method="POST">
        <table border="1" cellpadding="5">
<caption>
<h2>List of users</h2>
</caption>
<tr>
<th>Name</th>
<th>Email</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${personsList}" var="person">
        <tr>
			<td><c:out value="${person.name}" /></td>
			<td><c:out value="${person.emailID}" /></td>
		    <td><a href="/editUser?id=<c:out value="${person.emailID}" />">Edit</a></td>
			<td><a href="/deleteUser?id=<c:out value="${person.emailID}" />">Delete</a></td>
	   </tr>
</c:forEach>
</table>
			</form:form>  
		</div>
	</div>


</body>
</html>