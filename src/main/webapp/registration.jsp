<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div class="container-sm">
		<div class="row justify-content-center">
			<div class="col-4">
			<h1 class="text-center">Registration</h1>
				<form action="registration" method="post" >
				<input type="text" placeholder="Login" name="login"
						class="form-control" value="${login}">
						<br>
						<input type="password" placeholder="Password" name="password" class="form-control" value="${password}">
						<br>
						<input type="password" placeholder="Repeant Password" name="passwordRep" class="form-control" value="">
						<br>
						
						<div class="d-grid gap-2">
						<button type="submit" class="btn btn-outline-success">Enter</button>
						</div>
				</form>
				<br>
				<div class="container px-5">
						<div class="row gx-5">
							<div class="col text-start">
								<a href="index.jsp">enter</a>
							</div>
							
						</div>
					</div>
				<br> ${message}
			</div>
		</div>
	</div>


</body>
</html>