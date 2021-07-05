<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<h1> <c:out value ="${product.name}"> </c:out> </h1>
	<div class = "wrapper">
	
		<div class = "leftSide">
			<table>
			    <thead>
			        <tr> 
			        	<td> Categories </td>
	
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${product.categories}" var="category">
			        <tr>
			            <td> <c:out value="${category.name}"> </c:out></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>




		<div>
			<form:form action='/products/${product.id}' method="post" modelAttribute="category">
				<form:select id="category" name="category" path="id">
					<c:forEach items="${categories}" var="category">
					    <option value="${category.id}">${category.name}</option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Submit">
			</form:form>
		</div>

	</div>
	<div>
		<a href = "<c:url value = "/products"/>">BACK</a>
	</div>
</body>
</html>