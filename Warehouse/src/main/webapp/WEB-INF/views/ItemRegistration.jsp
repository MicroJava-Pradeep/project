<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="utf-8">
<style>
.err {
	color: red;
	font: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to Item Registration page</h3>
		<form:form action="insert" method="post" modelAttribute="item">
				Item Code:<form:input path="iCode" />
		                 <form:errors path="iCode" cssClass="err" /><br><br>
				Item Dimension:	W:<form:input path="wid" />
					<form:errors path="wid" cssClass="err" />
								L:<form:input path="len" />
					<form:errors path="len" cssClass="err" />
								H:<form:input path="hgt" />
					<form:errors path="hgt" cssClass="err" />
		<br>
		<br>
					Base Cost:<form:input path="baseCost" />
		<form:errors path="baseCost" cssClass="err" />
		<br>
		<br>		
					Base Currency:<form:select path="baseCurrency">
			<form:option value="">-SELECT-</form:option>
			<form:option value="INR">-INR-</form:option>
			<form:option value="USD">-USD-</form:option>
			<form:option value="AUS">-AUS-</form:option>
			<form:option value="ERU">-ERU-</form:option>
		</form:select>
		<form:errors path="baseCurrency" cssClass="err" />
		<br>
		<br>
					Item UOM:<form:select path="uom.id">
			<form:option value="">-SELECT-</form:option>
			<form:options items="${uoms}" itemLabel="model" itemValue="id" />
		</form:select>
		<form:errors path="uom.id" cssClass="err" />
		<br>
		<br>
					
						Order Method:(Sale):<form:select path="saleType.id">
			<form:option value="">-SELECT-</form:option>
			<form:options items="${Sales}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="saleType.id" cssClass="err" />
		<br>
		<br>
						Order Method:(Purchase):<form:select path="purchaseType.id">
			<form:option value="">-SELECT-</form:option>
			<form:options items="${Purchases}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="purchaseType.id" cssClass="err" />
		<br>
		<br>
	                 
				  Item Vendors:<form:select path="venTypes">
			<form:option value="">--SELECT--</form:option>
			<form:options items="${vendors}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="venTypes" cssClass="err" />
		<br>
		<br>
							Item Customers:
							<form:select path="custTypes">
			<form:option value="">--SELECT--</form:option>
			<form:options items="${customers}" itemLabel="code" itemValue="id" />
		</form:select>
		<form:errors path="custTypes" cssClass="err" />
		<br>
		<br>		
				
					Description:<form:textarea path="dsc" />
		<form:errors path="dsc" cssClass="err" />
		<br>
		<br>

		<input type="submit" value="Create Item">

	</form:form>


	${message}
</body>
</html>