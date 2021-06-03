<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<title>StockBalance</title>
</head>
<body>



<br>
<br>
<div class="container sm">
<div class="text-center">
<h1>StockBalance</h1>
<h2>ENTER (вход)</h2>
</div>

<div class="row justify-content-center">
	<div class="col-4">
	
<form action="showstock" method="post" >
<input type="text" placeholder="Login" name="login" class="form-control" value="${login}">
<br>
<input type="password" placeholder="Password" name="password" class="form-control" value="${password}">
<br>
<button type="submit" class="btn btn-outline-success">Enter</button>
<br>
</form>
<br>
${message}
</div>

	</div>
</div>







</body>
</html>