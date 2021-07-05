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
	<h1> All Products </h1>
		<table>
		    <thead>
		        <tr>
		            <th>Product Name</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${products}" var="product">
		        <tr>
		            <td> <c:out value="${product.name}"></c:out></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href = "<c:url value = "/products/new"/>">Create a new product</a>
</body>
</html>