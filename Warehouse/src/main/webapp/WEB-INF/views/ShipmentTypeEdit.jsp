<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
	color: red;
	font: 15px;
}
</style>
</head>
<body>
	<h2>Welcome To Shipment Type Page</h2>

	<form:form action="update" method="post" modelAttribute="shipmentType">
	ID     :  <form:input path="id" readOnly="true" />
		</br><br>
Shipment Model:<form:select path="mode">
			<form:option value="">-Select-</form:option>
			<form:option value="air">Air</form:option>
			<form:option value="truck">Truck</form:option>
			<form:option value="ship">Ship</form:option>
			<form:option value="train">Train</form:option>
		</form:select>
		<form:errors path="mode" cssClass="err"/>
		</br><br>
Shipment Code:<form:input path="code" />
<form:errors path="code" cssClass="err"/>
		</br><br>
Enable Shipment:<form:checkbox path="enabled" value="yes" />Yes
<form:errors path="enabled" cssClass="err"/>
		</br><br>
Shipment Grade:	<form:radiobutton path="grade" value="a" />A
				<form:radiobutton path="grade" value="b" />B
				<form:radiobutton path="grade" value="c" />C
				<form:errors path="grade" cssClass="err"/>
		</br><br>
Description:<form:textarea path="dsc" />
		<form:errors path="dsc" cssClass="err"/>
		</br><br>
		<input type="submit" value="Create Shipment" />
	</form:form>
</body>
</html>