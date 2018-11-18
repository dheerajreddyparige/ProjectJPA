<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session Schedule Management System</title>
</head>
<body>
<h1 align="center">Scheduled Sessions</h1>
	<div align="center">
		<table border=1>
			<tr>
				<th>Session Name</th>
				<th>Duration(Days)</th>
				<th>Faculty</th>
				<th>Mode</th>
				<th></th>
			</tr>
			<c:forEach items="${traininglist}" var="list">
				<tr>
					<td>${list.name}</td>
					<td>${list.duration}</td>
					<td>${list.faculty}</td>
					<td>${list.mode1}</td>
					<td><a modelattributle="name" href="enroll.do">Enroll Me</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>Click a Hotel name to start Booking</h3>
	</div>
</body>
</html>