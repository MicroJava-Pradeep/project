<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" method="post" modelAttribute="uomtype">
	ID     :  <form:input path="id" readOnly="true" />
		</br>
			Uom Type :<form:select path="utype">
		<form:option value="">-SELECT-</form:option>
		<form:option value="pack">PACKING</form:option>
		<form:option value="no-pack">NO-PACKING</form:option>
		<form:option value="NA">NA</form:option>		
		</form:select>
		<form:errors path="utype" cssClass="err"/>
		<br>
		<br>
		Uom Model:<form:input path="model" />
		<form:errors path="model" cssClass="err"/>
		
		<br>
		<br>
		</br>
		Description:<form:input path="dsc" />
		<form:errors path="dsc" cssClass="err"/>
	
		<br>
		<br>
		<input type="submit" value="Create Uom">
		<br>
		<br>

		</br>	</form:form>
</body>
</html>