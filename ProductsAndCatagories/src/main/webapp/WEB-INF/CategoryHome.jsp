<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> All Categories </h1>
	<table>
	    <thead>
	        <tr>
	            <th>Category Name</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${categories}" var="category">
	        <tr>
	            <td> <c:out value="${category.name}"></c:out></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href = "<c:url value = "/categories/new"/>">Create a new category</a>
</body>
</html>