<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Search Results</h2>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Stock Quantity</th>
        </tr>
        <c:forEach var="result" items="${results}">
            <tr>
                <td>${result.productId}</td>
                <td>${result.name}</td>
                <td>${result.category}</td>
                <td>${result.price}</td>
                <td>${result.stockQuantity}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="products">Back to Product List</a>

</body>
</html>