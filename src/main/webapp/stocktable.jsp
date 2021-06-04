<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />

<title>Stock TABLE</title>
</head>
<body>

	<div class="container sm">

		<h3 class="text-center">Hello ${login}</h3>

		<a href="index.jsp"><button class="btn btn-outline-info">Назад</button></a>

		<br> <br>
		<form action="serchbydate" method="post" accept-charset="UTF-8">
			<input type="text" placeholder="Enter Article Number"
				name="articleNumber"> <input type="date" value="${dateIn}"
				name="dateIn"> - <input type="date" value="${dateOut}"
				name="dateOut">
			<button type="submit">search</button>
		</form>


		<p style="color: red;">${error }</p>


		<br> <br>
		<div>
			<form action="serchbyarticlenumber" method="post"
				accept-charset="UTF-8">
				<input type="text" placeholder="Enter Article Number"
					name="articleNumber">
				<button type="submit">search</button>
			</form>
		</div>
		<br> <br>



		<table class="table">
			<thead>
				<tr>
					<td><c:out value="Article" /></td>
					<td><c:out value="Name" /></td>
					<td><c:out value="Date" /></td>

					<td><c:out value="Stock" /></td>
				</tr>
			</thead>
			<c:forEach items="${allArticles}" var="art">
				<tr>
					<th scope="row"><c:out value="${art.article}" /></th>
					<td><c:out value="${art.name}" /></td>
					<td><fmt:formatDate value="${art.date}" pattern="dd-MM-yyyy" /></td>
					<td><c:out value="${art.stock}" /></td>
				</tr>
			</c:forEach>

		</table>
	</div>





</body>
</html>