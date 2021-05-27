<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Hello ${login}</h3>


<br>
<input type="date" value="2020-05-25">

<br>
<br>




<table border="1" >

    <tr>
        <td><c:out value="Article"/></td>
        <td><c:out value="Name"/></td>      
        <td><c:out value="Date"/></td>     
         
        <td><c:out value="Stock"/></td>  
    </tr>

<c:forEach items="${allArticles}" var="art">
    <tr>
        <td><c:out value="${art.article}"/></td>
        <td><c:out value="${art.name}"/></td>
        <td><c:out value="${art.date}"/></td>
        <td><c:out value="${art.stock}"/></td>  
    </tr>
</c:forEach>

</table>



</body>
</html>