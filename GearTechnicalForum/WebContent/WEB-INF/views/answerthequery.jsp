<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gear Technical Forum</title>
</head>
<body>
<h1>Gear Technical Forum</h1>
<h2>Answer the Query</h2>
<form:form action="success" modelAttribute="success">
<form:set var = "query" value = "${q}"/>
         Query id:  <form:out value= "${query.getQueryId()}" readon;y/><br>
         Select Technology:  <form:out value="${query.getTechnology()}" readonly/><br>
         Question:  <form:out value="${query.getQuery()}" readonly/><br>
         Question Raised By:  <form:out value="${query.getQueryRaisedBy()}" readonly/><br>
         Solution:<input type="text" id="solution" name="solution" modelattribute="solution"/><br>
         <select name="listId" value="Please Select" id="single1" modelattribute="option"><br>
             <option value="1">Uma</option>
             <option value="2">Rahul</option>
             <option value="3">Kavitha</option>
             <option value="4">Hema</option>
         </select>
         <input type="submit" value="Update Query"/>
         </form:form>  
</body>
</html>