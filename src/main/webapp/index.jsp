<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<fmt:requestEncoding value="utf-8"/>
<html>
<head>
<meta charset="UTF-8">
<title>StockBalance</title>
</head>
<body>

<h1>StockBalance</h1>
<h2>ENTER</h2>

<form action="showstock" method="post">

<input type="text" placeholder="login" name="login">
<br> <br>
<input type="text" placeholder="password" name="password">
<br> <br>
<button type="submit">Enter</button>

</form>




</body>
</html>