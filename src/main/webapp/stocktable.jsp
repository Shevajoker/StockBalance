<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Stock TABLE</title>
</head>
<body>

<h3>Hello ${login}</h3>

<a href="index.jsp">Назад</a>
<br>

<br>
<form action="serchbydate" method="post" accept-charset="UTF-8">
	<input type="text" placeholder="Enter Article Number" name="articleNumber">
	<input type="date" value="${dateIn}" name="dateIn">
	-
	<input type="date" value="${dateOut}" name="dateOut">
	<button type="submit">search</button>
</form>

${dateIn}

<p style="color: red;">${error }</p>


<br>
<br>
<div>
<form action="serchbyarticlenumber" method="post" accept-charset="UTF-8">
	<input type="text" placeholder="Enter Article Number" name="articleNumber">
	<button type="submit">search</button>
</form>
</div>
<br>
<br>




<table border="1">

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
        <td><fmt:formatDate value="${art.date}" pattern="dd-MM-yyyy"/></td>
        <td><c:out value="${art.stock}"/></td>  
    </tr>
</c:forEach>

</table>



</body>
</html>