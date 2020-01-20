<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>>
</head>
<body>
<div class="container">
<div class="card">
<div class="card-header bg-warning">
	<h2>WelCome To Item Data Page</h2>
</div>
<div class="card-body ">

	<a href="excel">Excel</a>|<a href="pdf">PDF</a>
	<c:choose>
	<c:when test="${!empty items}">
	<table class="table table-hover table-responsive table-bordered" >
			<th>ID</th>
			<th>Item Code</th>
			<th>Item Dimension</th>
			<th>Base Cost</th>
			<th>Base Currency</th>
			<th>UOM</th>
			<th>Sales</th>
			<th>Purchase</th>
			<th>Vendors</th>
			<th>Customers</th>
			<th>Description</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${items}" var="i">
			<tr>
				<td><c:out value="${i.id}"></c:out></td>
				<td><c:out value="${i.iCode}"></c:out></td>
				<td><c:out value="${i.wid}"></c:out>, <c:out value="${i.len}"></c:out>,
					<c:out value="${i.hgt}"></c:out></td>
				<td><c:out value="${i.baseCost}"></c:out></td>
				<td><c:out value="${i.baseCurrency }"></c:out></td>
				<td><c:out value="${i.uom.model}"></c:out></td>
				<td><c:out value="${i.saleType.code}"></c:out></td>
				<td><c:out value="${i.purchaseType.code}"></c:out></td>
				<td><c:forEach items="${i.venTypes}" var="ven">
						<c:out value="${ven.code}" />,
	</c:forEach></td>
				<td><c:forEach items="${i.custTypes}" var="cust">
						<c:out value="${cust.code}" />,
	</c:forEach></td>

				<td><c:out value="${i.dsc}"></c:out></td>
				<td><a href="delete?id=${i.id}" class="btn btn-danger">DELETE</a></td>
				<td><a href="edit?id=${i.id}" class="btn btn-success">EDIT</a></td>

			
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>	
		<div class="text-info">No Data Found in Database</div>		
	</c:otherwise>
	</c:choose>
	</div>
	<c:if test="${message ne null}" >
	<div class="card-footer bg-success">${message}</div>
	</c:if>
</body>
</html>