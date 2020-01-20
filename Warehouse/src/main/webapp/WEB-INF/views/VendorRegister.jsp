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
	<h2>Welcome To Vendor Registration Page</h2>
	<form:form action="insert" method="post" modelAttribute="vendor">
Vendor Name: <form:input path="venName" />
<form:errors path="venName" cssClass="err"/>
<br><br>
Vendor Code: <form:select path="venCode">
			<form:option value="">--Select--</form:option>
			<form:option value="CAT">CAT</form:option>
			<form:option value="RES">RES</form:option>

		</form:select>
		<form:errors path="venCode" cssClass="err"/>
<br><br>	
Vendor Desg:<form:radiobutton path="venDesg" value="sale"/>Sale
			<form:radiobutton path="venDesg" value="service"/>Service
			<form:radiobutton path="venDesg" value="both"/>Both
			<form:errors path="venDesg" cssClass="err"/>
<br><br>
Vendor Preserve:<form:checkbox path="venPreserve" value="a"/>A
<form:checkbox path="venPreserve" value="b"/>B
<form:checkbox path="venPreserve" value="c"/>C
<form:errors path="venPreserve" cssClass="err"/>
<br><br>
<input type="submit" value="Create Vendor"/>
</form:form>

${message}
</body>
</html>