<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.err{
	color: red;
	font: 15px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="orderMethod">
Order Mode:<form:radiobutton path="mode" value="sale"/>Sale
			<form:radiobutton path="mode" value="purchase"/>Purchase
			<form:errors path="mode" cssClass="err"/><br><br>
Order Code:<form:input path="code"/>
<form:errors path="code" cssClass="err"/><br><br>

Order Method:<form:select path="method">
				<form:option value="">-SELECT-</form:option>
				<form:option value="fifo">FIFO</form:option>
				<form:option value="lifo">LIFO</form:option>
				<form:option value="fcfo">FCFO</form:option>
				<form:option value="fefo">FEFO</form:option>
			</form:select>
			<form:errors path="method" cssClass="err"/><br><br>
Order Accept:<form:checkbox path="accept" value="multi-model"/>Multi-Model
<form:checkbox path="accept" value="acceptreturn"/>Accept Return
<form:errors path="accept" cssClass="err"/><br><br>
Description: <form:textarea path="dsc"/>
<form:errors path="dsc" cssClass="err"/><br><br>
<input type="submit" value="Create Order Method" />
</form:form>
${message}
</body>
</html>