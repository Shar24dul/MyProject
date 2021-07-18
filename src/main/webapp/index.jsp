<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="show" method="POST">
		<table>
			<tr>
				<td>Employee Id:</td>
				<td><input type="number" name="empId" /></td>
			</tr>
			<tr>
				<td>Employee Name:</td>
				<td><input type="text" name="empName" /></td>
			</tr>
			<tr>
				<td>Employee Salary:</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td>Employee City:</td>
				<td><input type="number" name="addressId"></td>
			</tr>
			<tr>
				<td>Employee City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>City pincode:</td>
				<td><input type="text" name="pincode"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>