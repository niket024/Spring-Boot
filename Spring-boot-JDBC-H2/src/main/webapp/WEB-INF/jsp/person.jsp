<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<center>
	<h1>Create Person</h1>
	
	<form:form action="add" method="POST" commandName="person">
		<table>
			<tr>
				<td>Full Name</td>
				<td><form:input path="fullName" placeholder="firstname" class="form-control"/></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><form:input path="dateOfBirth" class="form-control"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add" class="btn btn-default"/>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
</center>
</body>
</html>