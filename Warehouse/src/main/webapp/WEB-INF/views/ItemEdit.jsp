<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="utf-8">
<style>
.div {
	margin-top: 20px;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 20px;
}

.pad {
	border: 1px solid black;
	border-radius: 25px;
	background-color: Orange;
}

.text {
	font-weight: bold;
}
</style>
<title>Insert title here</title>
</head>
<body style="background-color: grey;">

	<div class="container">


		<div class="row div" style="">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 pad">
				<br></br>
				<h3>Welcome to Item Edit page</h3>
				<br> <br>
				<form:form action="insert" method="post" modelAttribute="item">
					<div class="row">
						<div class="col-sm-4 text">Item Code:</div>
						<div class="col-sm-6">
							<form:input path="iCode" class="form-control" />
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4 text ">Item Dimension:</div>
						<div class="col-sm-6">

							<div class="row">

								<div class="col-sm-4">
									W:
									<form:input path="wid" size="3" class="form-control" />
								</div>

								<div class="col-sm-4">
									L:
									<form:input path="len" class="form-control" />
								</div>
								<div class="col-sm-4">
									H:
									<form:input path="hgt" class="form-control" />
								</div>

							</div>


						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4 text">Base Cost:</div>
						<div class="col-sm-6">
							<form:input path="baseCost" class="form-control" />
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4 text">Base Currency:</div>
						<div class="col-sm-6">
							<form:select path="baseCurrency" class="form-control">
								<form:option value="select">-SELECT-</form:option>
								<form:option value="INR">-INR-</form:option>
								<form:option value="USD">-USD-</form:option>
								<form:option value="AUS">-AUS-</form:option>
								<form:option value="ERU">-ERU-</form:option>
							</form:select>
						</div>
						<div class="col-sm-2"></div>
					</div>

					<hr class="">
					<div class="row">
						<div class="col-sm-4 text">Item UOM:</div>
						<div class="col-sm-6">
							<form:select path="uom.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${uoms}" itemLabel="model" itemValue="id" />

							</form:select>
						</div>
						<div class="col-sm-2"></div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-4 text">Order Method:(Sale)</div>
						<div class="col-sm-6">
							<form:select path="saleType.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${Sales}" itemLabel="code" itemValue="id" />
							</form:select>
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4 text">Order Method:(Purchase)</div>
						<div class="col-sm-6">
							<form:select path="purchaseType.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${Purchases}" itemLabel="code"
									itemValue="id" />
							</form:select>
						</div>
						<div class="col-sm-2"></div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-6">
							<div class="text">Item Vendors:</div>
							<form:select path="${venTypes.id}" multiple="true"
								class="form-control">
								<form:option value="" disabled="true">--SELECT--</form:option>
								<form:options items="${vendors}" itemLabel="code" itemValue="id" />
							</form:select>

						</div>
						<div class="col-sm-6">
							<div class="text">Item Customers:</div>
							<form:select path="${custTypes.id}" multiple="true"
								class="form-control">
								<form:option value="" disabled="true">--SELECT--</form:option>
								<form:options items="${customers}" itemLabel="code"
									itemValue="id" />
							</form:select>

						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-4 text">Description:</div>
						<div class="col-sm-6">
							<form:textarea path="dsc" class="form-control" />
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<input type="submit" value="Update Item"
								class="btn btn-primary btn-block">
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<br>
				</form:form>
			</div>




		</div>
		<div class="col-sm-3"></div>
	</div>
	</div>
	${message}
</body>
</html>