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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header bg-warning">
			<h2>WelCome To WhUser Method Data Page</h2>
		</div>
		<div class="card-body ">

			<a href="excel">Excel</a>|<a href="pdf">PDF</a>
			<c:choose>
				<c:when test="${!empty list}">
					<table class="table table-hover table-bordered table-responsive">		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>CODE</th>
			<th>USER FOR</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>USER ID TYPE</th>
			<th>IF OTHER</th>
			<th>ID NUMBER</th>
			<th colspan="1">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td><c:out value="${user.id}"></c:out></td>
				<td><c:out value="${user.type}"></c:out></td>
				<td><c:out value="${user.code}"></c:out></td>
				<td><c:out value="${user.forType}"></c:out></td>
				<td><c:out value="${user.email}"></c:out></td>
				<td><c:out value="${user.contact}"></c:out></td>
				<td><c:out value="${user.idType}"></c:out></td>
				<td><c:out value="${user.ifOther}"></c:out></td>
				<td><c:out value="${user.idNum}"></c:out></td>
				<td><a href="delete?id=${user.id}" class="btn  btn-danger">DELETE</a></td>
				<td><a href="edit?id=${user.id}" class="btn  btn-success">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	</
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