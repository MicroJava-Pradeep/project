<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.err {
	color: red;
	font: 15px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Purchase Registration Form</h2>
	<form:form action="insert" method="post" modelAttribute="purchaseOrder">
	Order Code:   <form:input path="orderCode" />
		<form:errors path="orderCode" cssClass="err" />
		<br>
		<br>
		Shipment Code:<form:select path="shipmentCode.id">
			<form:option value="">--Select--</form:option>
			<form:options items="${ship}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="shipmentCode" cssClass="err" />
		<br>
		<br>
		Vendor:		  <form:select path="vendor">
			<form:option value="" >--Select--</form:option>
			<form:options items="${whuser}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="vendor" cssClass="err" />
		<br>
		<br>
		<br>
		<br> 
	Refrence Number:<form:input path="refNum" />
		<form:errors path="refNum" cssClass="err" />
		<br>
		<br>
		<br>
		<br>
	Quality Check:<form:radiobutton path="qualityCheck" value="required" />Required		
	<form:radiobutton path="qualityCheck" value="not Required" />Not Required	
	<form:errors path="qualityCheck" cssClass="err" />
		<br>
		<br>
		<br>
		<br>
	Default Status:<form:input  value="Open" path="poStatus"/>
		<br>
		<br>
	Description:<form:textarea path="poDsc" />
		<form:errors path="poDsc" cssClass="err" />
		<br>
		<br>
		

		<input type="submit" value="Register">
	</form:form>
</body>
${msg}
</html>