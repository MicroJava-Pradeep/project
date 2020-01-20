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
	<form:form action="update" method="post" modelAttribute="whUserType">
	ID:<form:input path="id" readonly="true"/>
User Type: <form:radiobutton path="type" value="vendor" />Vendor
			<form:radiobutton path="type" value="customer" />Customer</br>
			
User Code:<form:input path="code" />
		</br>
User For:<form:input path="forType" />
		</br>
User Email:<form:input path="email" />
		</br>
User Contact:<form:input path="contact" />
		</br>
User type:<form:select path="idType">
			<form:option value="select">--SELECT</form:option>
			<form:option value="PAN">PAN CARD</form:option>
			<form:option value="AADHAR">AADHAR</form:option>
			<form:option value="VOTERID">VOTER-ID</form:option>
			<form:option value="OTHER">OTHER</form:option>

		</form:select>
		</br>
If Other:<form:input path="ifOther" />
		</br>
ID Number:<form:input path="idNum" />
		</br>

		<input type="submit" value="Update WhUserType" />



	</form:form>


</body>
</html>