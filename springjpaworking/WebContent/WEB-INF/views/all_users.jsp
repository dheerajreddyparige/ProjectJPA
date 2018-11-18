<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Users List</title>
</head>
<body>	
	
				<div class="container">
				  	<h2>user Details</h2>
				  
				  <table class="table">
					    <thead>
						      <tr>
						        <th>User ID</th>
						        <th>User Name</th>
						        <th>Password</th>
						        <th>BirthDate</th>
						        <th>Email</th>
						        
						      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach var="u" items="${userList}">
						      <tr class="success">
						        <td>${u.userid}</td>				        
						        <td>${u.username}</td>
						        <td>${u.password}</td>
						        <td>${u.birthdate}</td>
						        <td>${u.emailId}</td>						        
						        <td><a href="http://localhost:8080/Mod2example/cust/preeditc?customerid=${u.userid}">edit</a></td>
						        <td><a href="http://localhost:8080/Mod2example/cust/deletec?customerid=${u.userid}">delete</a></td>
						      </tr>      
						    </c:forEach>
					    </tbody>
				  </table>
			</div>
	
</body>
</html>