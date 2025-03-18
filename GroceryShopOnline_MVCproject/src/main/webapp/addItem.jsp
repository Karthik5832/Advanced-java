<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Add Grocery Item</h2>
    <form:form action="save" modelAttribute="groceryItem">
        <label for="name">Name:</label>
        <form:input path="name" /><br/>

        <label for="category">Category:</label>
        <form:input path="category" /><br/>

        <label for="price">Price:</label>
        <form:input path="price" /><br/>

        <label for="stockQuantity">Stock Quantity:</label>
        <form:input path="stockQuantity" /><br/>

        <input type="submit" value="Add Item" />
    </form:form>

</body>
</html>