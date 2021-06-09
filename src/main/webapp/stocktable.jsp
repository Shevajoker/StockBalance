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
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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



<div style="width:3000px;">
  <canvas id="myChart"></canvas>
</div>



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


<script>

var table = document.getElementsByClassName('table');
console.log(table);
console.log(table[0].rows[0].cells[0].textContent);
console.log(table[0].rows.length);
rowsCount = table[0].rows.length;

var labelsData = "[";
var dataData = "[";

    for(i = 1; i < table[0].rows.length-1; i++){
    	labelsData += "'" + table[0].rows[i].cells[2].textContent + "',";
    	dataData += table[0].rows[i].cells[3].textContent + ","
    	
    	
    }
    labelsData += "'" + table[0].rows[rowsCount-1].cells[2].textContent + "']";
    dataData += table[0].rows[rowsCount-1].cells[3].textContent + "]";

    console.log(labelsData);
    console.log(dataData);








var ctx = document.getElementById('myChart').getContext('2d');
ctx.canvas.width = 200;

var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: labelsData,
        datasets: [{
            label: 'DIESEL фасад F8/D2 (32) энигма',
            data: dataData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)' 
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});



       </script> 




</body>
</html>