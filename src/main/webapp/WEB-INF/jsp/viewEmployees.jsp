<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Display all employees</h1>
</body>
<table>
  <tr>
    <th>Employee id</th>
    <th>Employee name</th>
  </tr>
  <c:forEach var="employee" items="${emplist}">
  <tr>
    <td>${employee.id}</td>
    <td>${employee.name}</td>
    <td><a href="editemp/${employee.id}">Edit</a></td> 
  </tr>
  
  </c:forEach>
  
</table>

</html>