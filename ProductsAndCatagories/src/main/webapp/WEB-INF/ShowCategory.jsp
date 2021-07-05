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
		<h1> <c:out value ="${category.name}"> </c:out> </h1>
	<div class = "wrapper">
	
		<div class = "leftSide">
			<table>
			    <thead>
			        <tr> 
			        	<td> Categories </td>
	
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${category.products}" var="product">
			        <tr>
			            <td> <c:out value="${product.name}"> </c:out></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		
		
		<div>
			<form:form action='/categories/${category.id}' method="post" modelAttribute="product">
				<form:select id="product" name="product" path="id">
					<c:forEach items="${products}" var="product">
					    <option value="${product.id}">${product.name}</option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Submit">
			</form:form>
		</div>
		
	
	</div>
	<div>
		<a href = "<c:url value = "/categories"/>">BACK</a>
	</div>


</body>
</html>