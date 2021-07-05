<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>New Category</h1>
	<form:form action="/categories/new/create" method="post" modelAttribute="category">
	    <p>
	        <form:label path="name">Category Name: </form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>	    
	    <input type="submit" value="Submit"/>
	</form:form>    
	
</body>
</html>