 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="1"
           bgcolor="green" border="2" width="70%" cellpadding="2">  
<tr><th style="background-color:DodgerBlue;">Id</th><th style="background-color:Tomato;">Name</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
 
<%--    <td><a href="editemp/${emp.id}">Edit</a></td>   --%>
<%--    <td><a href="deleteemp/${emp.id}">Delete</a></td>   --%>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="signUpPage">Add New Employee</a>  