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
	font-size: 25px;
}
</style>
</head>
<body>
	<form:form action="save" method="post" modelAttribute="whUserType">
User Type: <form:radiobutton path="type" value="vendor" />Vendor
			<form:radiobutton path="type" value="customer" />Customer
			<form:errors path="type" cssClass="err"/></br><br>
		
User Code:<form:input path="code" />
	
		<form:errors path="code" cssClass="err"/></br><br>
		
User For:<form:input path="forType" />
		
		<form:errors path="forType" cssClass="err"/></br><br>
		
User Email:<form:input path="email" />
		 
		<form:errors path="email" cssClass="err"/></br><br>
		
User Contact:<form:input path="contact" />
		
		<form:errors path="contact" cssClass="err"/></br><br>
		
User type:<form:select path="idType">
			<form:option value="">--SELECT--</form:option>
			<form:option value="PAN">PAN CARD</form:option>
			<form:option value="AADHAR">AADHAR</form:option>
			<form:option value="VOTERID">VOTER-ID</form:option>
			<form:option value="OTHER">OTHER</form:option>

		</form:select>
		<form:errors path="idType" cssClass="err"/></br><br>
		
If Other:<form:input path="ifOther" />
		</br><br>
ID Number:<form:input path="idNum" />
		
		<form:errors path="idNum" cssClass="err"/></br><br>
			
<input type="submit" value="Create WhUserType" />
		</form:form>

	${message}
	${msg}
</body>
</html>